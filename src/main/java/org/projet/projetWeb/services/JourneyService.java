package org.projet.projetWeb.services;


import org.projet.projetWeb.model.Journey;
import org.projet.projetWeb.model.Trajet;
import org.projet.projetWeb.model.User;
import org.projet.projetWeb.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JourneyService {

    private final JourneyRepository journeyRepository;
    private final TrajetService trajetService;

    @Autowired
    public JourneyService(JourneyRepository journeyRepository,TrajetService trajetService) {

        this.journeyRepository = journeyRepository;
        this.trajetService = trajetService;
    }
    public List<Trajet> findMatchingTrajets(Trajet passengerTrajet) {
        List<Journey> matchingJourneys = findMatchingJourneys(passengerTrajet);

        if (matchingJourneys.isEmpty()) {
            return Collections.emptyList(); // Return an empty list if no matching journeys are found
        }

        // Extract the trajets from the matching journeys
        List<Trajet> matchingTrajets = matchingJourneys.stream()
                .map(Journey::getTrajet)
                .collect(Collectors.toList());

        return matchingTrajets;
    }
    public List<Journey> findMatchingJourneys(Trajet passengerTrajet) {
        // If passenger has a saved trajet
        if (passengerTrajet != null) {
            // Fetch the geolocation data for the departure and destination addresses of passenger's trajet
            Double passengerDepartureLatitude = passengerTrajet.getDepartureLatitude();
            Double passengerDepartureLongitude = passengerTrajet.getDepartureLongitude();
            Double passengerDestinationLatitude = passengerTrajet.getDestinationLatitude();
            Double passengerDestinationLongitude = passengerTrajet.getDestinationLongitude();

            // If geolocation data is available for both addresses
            if (passengerDepartureLatitude != null && passengerDepartureLongitude != null &&
                    passengerDestinationLatitude != null && passengerDestinationLongitude != null) {
                // Search for drivers within 10 km of departure and destination
                List<Journey> nearbyDrivers = findDriversWithinDistance(passengerTrajet, 10);

                // Filter drivers based on distance from destination and other conditions
                List<Journey> matchingJourneys = new ArrayList<>();
                for (Journey journey : nearbyDrivers) {
                    if (journey != null) {
                        Trajet trajetDriver = journey.getTrajet();
                        if (trajetDriver.getDepartureLongitude() == null || trajetDriver.getDepartureLatitude() == null || trajetDriver.getDestinationLongitude() == null || trajetDriver.getDestinationLatitude() == null) {
                            // Handle the case where any of the longitude or latitude values is null
                            trajetService.updateTrajet(trajetDriver.getTrajetID());
                        }
                        // Fetch the latitude and longitude values for the departure and destination addresses of driver's trajet
                        Double driverDepartureLatitude = trajetDriver.getDepartureLatitude();
                        Double driverDepartureLongitude = trajetDriver.getDepartureLongitude();
                        Double driverDestinationLatitude = trajetDriver.getDestinationLatitude();
                        Double driverDestinationLongitude = trajetDriver.getDestinationLongitude();

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

        // If no saved trajet is available or if there are no matching journeys, return an empty list
        return Collections.emptyList();
    }

//    public List<Journey> findMatchingJourneys(int passengerID) {
//        // Retrieve the passenger's journey details (if available)
//        Journey passengerJourney = journeyRepository.findTopByDriverUserIDOrderByJourneyCreationDateDesc(passengerID).orElse(null);
//        Trajet trajet = passengerJourney.getTrajet();
//
//        if (trajet.getDepartureLongitude() == null || trajet.getDepartureLatitude() == null || trajet.getDestinationLongitude() == null || trajet.getDestinationLatitude() == null) {
//            // Handle the case where any of the longitude or latitude values is null
//            trajetService.updateTrajet(trajet.getTrajetID());
//        }
//        // If passenger has a saved journey
//        if (passengerJourney != null) {
//            // Fetch the geolocation data for the departure and destination addresses of passenger's journey
//            Double passengerDepartureLatitude = passengerJourney.getTrajet().getDepartureLatitude();
//            Double passengerDepartureLongitude = passengerJourney.getTrajet().getDepartureLongitude();
//            Double passengerDestinationLatitude = passengerJourney.getTrajet().getDestinationLatitude();
//            Double passengerDestinationLongitude = passengerJourney.getTrajet().getDestinationLongitude();
//            // If geolocation data is available for both addresses
//            if (passengerDepartureLatitude != null && passengerDepartureLongitude != null &&
//                    passengerDestinationLatitude != null && passengerDestinationLongitude != null) {
//                // Search for drivers within 10 km of departure and destination
//                List<Journey> nearbyDrivers = findDriversWithinDistance(passengerJourney, 10);
//
//                // Filter drivers based on distance from destination and other conditions
//                List<Journey> matchingJourneys = new ArrayList<>();
//                for (Journey journey : nearbyDrivers) {
//                    if (journey != null) {
//                        Trajet trajetDriver = journey.getTrajet();
//                        if (trajetDriver.getDepartureLongitude() == null || trajetDriver.getDepartureLatitude() == null || trajetDriver.getDestinationLongitude() == null || trajetDriver.getDestinationLatitude() == null) {
//                            // Handle the case where any of the longitude or latitude values is null
//                            trajetService.updateTrajet(trajetDriver.getTrajetID());
//                        }
//                        // Fetch the latitude and longitude values for the departure and destination addresses of driver's journey
//                        Double driverDepartureLatitude = journey.getTrajet().getDepartureLatitude();
//                        Double driverDepartureLongitude = journey.getTrajet().getDepartureLongitude();
//                        Double driverDestinationLatitude = journey.getTrajet().getDestinationLatitude();
//                        Double driverDestinationLongitude = journey.getTrajet().getDestinationLongitude();
//
//                        // If latitude and longitude values are available for driver's addresses
//                        if (driverDepartureLatitude != null && driverDepartureLongitude != null &&
//                                driverDestinationLatitude != null && driverDestinationLongitude != null) {
//                            // Calculate relevance of the journey
//                            double relevance = calculateRelevance(driverDepartureLatitude, driverDepartureLongitude,
//                                    driverDestinationLatitude, driverDestinationLongitude,
//                                    passengerDepartureLatitude, passengerDepartureLongitude,
//                                    passengerDestinationLatitude, passengerDestinationLongitude);
//
//                            // Check if relevance satisfies conditions
//                            if (relevance > 0) {
//                                // Add the journey to the list of matching journeys
//                                matchingJourneys.add(journey);
//                            }
//                        }
//                    }
//                }
//                Collections.sort(matchingJourneys, Comparator.comparingDouble(journey -> {
//                    double driverDepartureLatitude = journey.getTrajet().getDepartureLatitude();
//                    double driverDepartureLongitude = journey.getTrajet().getDepartureLongitude();
//                    double driverDestinationLatitude = journey.getTrajet().getDestinationLatitude();
//                    double driverDestinationLongitude = journey.getTrajet().getDestinationLongitude();
//                    return calculateRelevance(driverDepartureLatitude, driverDepartureLongitude,
//                            driverDestinationLatitude, driverDestinationLongitude,
//                            passengerDepartureLatitude, passengerDepartureLongitude,
//                            passengerDestinationLatitude, passengerDestinationLongitude);
//                }));
//                return matchingJourneys;
//            }
//        }
//
//        // If no saved journey is available or if there are no matching journeys, return an empty list
//        return Collections.emptyList();
//    }


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
    private List<Journey> findDriversWithinDistance(Trajet passengerTrajet, double distance) {
        // Get the departure and destination addresses of the passenger's journey
        Double passengerDepartureLongitude = passengerTrajet.getDepartureLongitude();
        Double passengerDepartureLatitude  = passengerTrajet.getDepartureLatitude();
        Double passengerDestinationLongitude = passengerTrajet.getDestinationLongitude();
        Double passengerDestinationLatitude = passengerTrajet.getDestinationLatitude();

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
