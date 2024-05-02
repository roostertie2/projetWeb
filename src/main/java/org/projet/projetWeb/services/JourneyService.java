package org.projet.projetWeb.services;

import org.projet.projetWeb.model.GeocodeResponse;
import org.projet.projetWeb.model.Journey;
import org.projet.projetWeb.model.User;
import org.projet.projetWeb.repository.JourneyRepository;
import org.projet.projetWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.projet.projetWeb.services.GoogleService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class JourneyService {

    private final GoogleService googleService;
    private final JourneyRepository journeyRepository;
    private final UserRepository userRepository;

    @Autowired
    public JourneyService(GoogleService googleService, JourneyRepository journeyRepository, UserRepository userRepository) {
        this.googleService = googleService;
        this.journeyRepository = journeyRepository;
        this.userRepository = userRepository;
    }

    public List<Journey> findMatchingJourneys(User passenger) {
        // Retrieve the passenger's journey details (if available)
        Journey passengerJourney = journeyRepository.findTopByDriverUserIDOrderByJourneyCreationDateDesc(passenger.getUserID()).orElse(null);

        // If passenger has a saved journey
        if (passengerJourney != null) {
            // Fetch the geolocation data for the departure and destination addresses of passenger's journey
            GeocodeResponse passengerDepartureLocation = googleService.geocode(passengerJourney.getTrajet().getDepartureAddress());
            GeocodeResponse passengerDestinationLocation = googleService.geocode(passengerJourney.getTrajet().getDestinationAddress());

            // If geolocation data is available for both addresses
            if (passengerDepartureLocation != null && passengerDestinationLocation != null) {
                // Search for drivers within 10 km of departure and destination
                List<Journey> nearbyDrivers = findDriversWithinDistance(passengerJourney, 10);

                // Filter drivers based on distance from destination and other conditions
                GeocodeResponse driverDepartureLocation;
                GeocodeResponse driverDestinationLocation;

                List<Journey> matchingJourneys = new ArrayList<>();
                for (Journey journey : nearbyDrivers) {
                    // driverJourney = journeyRepository.findJourneyByDriver_userID(driver.getUserID()).orElse(null);

                    if (journey != null) {
                        // Fetch the geolocation data for the departure and destination addresses of driver's journey
                        driverDepartureLocation = googleService.geocode(journey.getTrajet().getDepartureAddress());
                       driverDestinationLocation = googleService.geocode(journey.getTrajet().getDestinationAddress());

                        if (driverDepartureLocation != null && driverDestinationLocation != null) {
                            // Calculate relevance of the journey
                            double relevance = calculateRelevance(driverDepartureLocation, driverDestinationLocation,
                                    passengerDepartureLocation, passengerDestinationLocation);

                            // Check if relevance satisfies conditions
                            if (relevance > 0) {
                                // Add the journey to the list of matching journeys
                                matchingJourneys.add(journey);
                            }
                        }
                        GeocodeResponse finalDriverDepartureLocation = driverDepartureLocation;
                        GeocodeResponse finalDriverDestinationLocation = driverDestinationLocation;
                        Collections.sort(matchingJourneys, Comparator.comparingDouble(journey2 -> calculateRelevance(finalDriverDepartureLocation, finalDriverDestinationLocation,
                                passengerDepartureLocation, passengerDestinationLocation)));
                    }


                }

                return matchingJourneys;
            }
        }

        // If no saved journey is available or if there are no matching journeys, return an empty list
        return Collections.emptyList();
    }


    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Radius of the Earth in kilometers
        final double R = 6371.0;

        // Convert latitude and longitude from degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Calculate the change in coordinates
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        // Haversine formula
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.pow(Math.sin(dLon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the distance
        double distance = R * c;

        return distance;
    }
    private double calculateRelevance(GeocodeResponse driverDepartureLocation, GeocodeResponse driverDestinationLocation,
                                      GeocodeResponse passengerDepartureLocation, GeocodeResponse passengerDestinationLocation) {
        // Calculate distances between driver's departure and destination and passenger's corresponding addresses
        double departureDistance = calculateDistance(driverDepartureLocation.getLatitude(), driverDepartureLocation.getLongitude(),
                passengerDepartureLocation.getLatitude(), passengerDepartureLocation.getLongitude());

        double destinationDistance = calculateDistance(driverDestinationLocation.getLatitude(), driverDestinationLocation.getLongitude(),
                passengerDestinationLocation.getLatitude(), passengerDestinationLocation.getLongitude());

        // Calculate total relevance as the sum of departure and destination distances
        double totalRelevance = departureDistance + destinationDistance;

        return totalRelevance;
    }
    private List<Journey> findDriversWithinDistance(Journey passengerJourney, double distance) {
        // Get the departure and destination addresses of the passenger's journey
        String passengerDepartureAddress = passengerJourney.getTrajet().getDepartureAddress();
        String passengerDestinationAddress = passengerJourney.getTrajet().getDestinationAddress();

        // Get a list of driver journeys within the specified distance
        List<Journey> nearbyDrivers = journeyRepository.findDriversWithinDistance(passengerDepartureAddress, passengerDestinationAddress);

        return nearbyDrivers;
    }

}
