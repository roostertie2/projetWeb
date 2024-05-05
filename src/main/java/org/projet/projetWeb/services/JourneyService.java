package org.projet.projetWeb.services;

import org.projet.projetWeb.model.GeocodeResponse;
import org.projet.projetWeb.model.Journey;
import org.projet.projetWeb.model.Trajet;
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
    private final TrajetService trajetService;

    @Autowired
    public JourneyService(GoogleService googleService, JourneyRepository journeyRepository, UserRepository userRepository,TrajetService trajetService) {
        this.googleService = googleService;
        this.journeyRepository = journeyRepository;
        this.userRepository = userRepository;
        this.trajetService = trajetService;
    }

    public List<Journey> findMatchingJourneys(User passenger) {
        // Retrieve the passenger's journey details (if available)
        Journey passengerJourney = journeyRepository.findTopByDriverUserIDOrderByJourneyCreationDateDesc(passenger.getUserID()).orElse(null);
        Trajet trajet = passengerJourney.getTrajet();

        if (trajet.getDepartureLongitude() == null || trajet.getDepartureLatitude() == null || trajet.getDestinationLongitude() == null || trajet.getDestinationLatitude() == null) {
            // Handle the case where any of the longitude or latitude values is null
            trajetService.updateTrajet(trajet.getTrajetID());
        }
        // If passenger has a saved journey
        if (passengerJourney != null) {
            // Fetch the geolocation data for the departure and destination addresses of passenger's journey
            Double passengerDepartureLatitude = passengerJourney.getTrajet().getDepartureLatitude();
            Double passengerDepartureLongitude = passengerJourney.getTrajet().getDepartureLongitude();
            Double passengerDestinationLatitude = passengerJourney.getTrajet().getDestinationLatitude();
            Double passengerDestinationLongitude = passengerJourney.getTrajet().getDestinationLongitude();
            // If geolocation data is available for both addresses
            if (passengerDepartureLatitude != null && passengerDepartureLongitude != null &&
                    passengerDestinationLatitude != null && passengerDestinationLongitude != null) {
                // Search for drivers within 10 km of departure and destination
                List<Journey> nearbyDrivers = findDriversWithinDistance(passengerJourney, 10);

                // Filter drivers based on distance from destination and other conditions
                List<Journey> matchingJourneys = new ArrayList<>();
                for (Journey journey : nearbyDrivers) {
                    if (journey != null) {
                        Trajet trajetDriver = journey.getTrajet();
                        if (trajetDriver.getDepartureLongitude() == null || trajetDriver.getDepartureLatitude() == null || trajetDriver.getDestinationLongitude() == null || trajetDriver.getDestinationLatitude() == null) {
                            // Handle the case where any of the longitude or latitude values is null
                            trajetService.updateTrajet(trajetDriver.getTrajetID());
                        }
                        // Fetch the latitude and longitude values for the departure and destination addresses of driver's journey
                        Double driverDepartureLatitude = journey.getTrajet().getDepartureLatitude();
                        Double driverDepartureLongitude = journey.getTrajet().getDepartureLongitude();
                        Double driverDestinationLatitude = journey.getTrajet().getDestinationLatitude();
                        Double driverDestinationLongitude = journey.getTrajet().getDestinationLongitude();

                        // If latitude and longitude values are available for driver's addresses
                        if (driverDepartureLatitude != null && driverDepartureLongitude != null &&
                                driverDestinationLatitude != null && driverDestinationLongitude != null) {
                            // Calculate relevance of the journey
                            double relevance = calculateRelevance(driverDepartureLatitude, driverDepartureLongitude,
                                    driverDestinationLatitude, driverDestinationLongitude,
                                    passengerDepartureLatitude, passengerDepartureLongitude,
                                    passengerDestinationLatitude, passengerDestinationLongitude);

                            // Check if relevance satisfies conditions
                            if (relevance > 0) {
                                // Add the journey to the list of matching journeys
                                matchingJourneys.add(journey);
                            }
                        }
                    }
                }
                Collections.sort(matchingJourneys, Comparator.comparingDouble(journey -> {
                    double driverDepartureLatitude = journey.getTrajet().getDepartureLatitude();
                    double driverDepartureLongitude = journey.getTrajet().getDepartureLongitude();
                    double driverDestinationLatitude = journey.getTrajet().getDestinationLatitude();
                    double driverDestinationLongitude = journey.getTrajet().getDestinationLongitude();
                    return calculateRelevance(driverDepartureLatitude, driverDepartureLongitude,
                            driverDestinationLatitude, driverDestinationLongitude,
                            passengerDepartureLatitude, passengerDepartureLongitude,
                            passengerDestinationLatitude, passengerDestinationLongitude);
                }));
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
    private double calculateRelevance(double driverDepartureLatitude, double driverDepartureLongitude,
                                      double driverDestinationLatitude, double driverDestinationLongitude,
                                      double passengerDepartureLatitude, double passengerDepartureLongitude,
                                      double passengerDestinationLatitude, double passengerDestinationLongitude) {
        // Calculate distances between driver's departure and destination and passenger's corresponding addresses
        double departureDistance = calculateDistance(driverDepartureLatitude, driverDepartureLongitude,
                passengerDepartureLatitude, passengerDepartureLongitude);

        double destinationDistance = calculateDistance(driverDestinationLatitude, driverDestinationLongitude,
                passengerDestinationLatitude, passengerDestinationLongitude);

        // Calculate total relevance as the sum of departure and destination distances
        double totalRelevance = departureDistance + destinationDistance;

        return totalRelevance;
    }
    private List<Journey> findDriversWithinDistancev0(Journey passengerJourney, double distance) {
        // Get the departure and destination addresses of the passenger's journey
        String passengerDepartureAddress = passengerJourney.getTrajet().getDepartureAddress();
        String passengerDestinationAddress = passengerJourney.getTrajet().getDestinationAddress();

        // Get a list of driver journeys within the specified distance
        List<Journey> nearbyDrivers = journeyRepository.findDriversWithinDistance(passengerDepartureAddress, passengerDestinationAddress);

        return nearbyDrivers;
    }
    private List<Journey> findDriversWithinDistance(Journey passengerJourney, double distance) {
        // Get the departure and destination addresses of the passenger's journey
        Double passengerDepartureLongitude = passengerJourney.getTrajet().getDepartureLongitude();
        Double passengerDepartureLatitude  = passengerJourney.getTrajet().getDepartureLatitude();
        Double passengerDestinationLongitude = passengerJourney.getTrajet().getDestinationLongitude();
        Double passengerDestinationLatitude = passengerJourney.getTrajet().getDestinationLatitude();

        // Get a list of all drivers
        List<Journey> allDrivers = journeyRepository.findAllDrivers();

        // Filter the drivers based on distance
        List<Journey> nearbyDrivers = new ArrayList<>();
        for (Journey driverJourney : allDrivers) {
            if (driverJourney.getTrajet().getDepartureLongitude() == null || driverJourney.getTrajet().getDepartureLatitude() == null || driverJourney.getTrajet().getDestinationLongitude() == null || driverJourney.getTrajet().getDestinationLatitude() == null) {
                // Handle the case where any of the longitude or latitude values is null
                trajetService.updateTrajet(driverJourney.getTrajet().getTrajetID());
            }
            double driverDepartureLatitude = driverJourney.getTrajet().getDepartureLatitude();
            double driverDepartureLongitude = driverJourney.getTrajet().getDepartureLongitude();
            double driverDestinationLatitude = driverJourney.getTrajet().getDestinationLatitude();
            double driverDestinationLongitude = driverJourney.getTrajet().getDestinationLongitude();

            // Calculate distance between passenger departure and driver departure
            double departureDistance = calculateDistance(passengerDepartureLatitude, passengerDepartureLongitude,
                    driverDepartureLatitude, driverDepartureLongitude);

            // Calculate distance between passenger destination and driver destination
            double destinationDistance = calculateDistance(passengerDestinationLatitude, passengerDestinationLongitude,
                    driverDestinationLatitude, driverDestinationLongitude);

            // If either departure or destination distance is within the specified range, add the driver to nearbyDrivers
            if (departureDistance <= distance || destinationDistance <= distance) {
                nearbyDrivers.add(driverJourney);
            }
        }

        return nearbyDrivers;
    }


}
