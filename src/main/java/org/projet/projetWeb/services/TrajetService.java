package org.projet.projetWeb.services;

import org.projet.projetWeb.model.GeocodeResponse;
import org.projet.projetWeb.model.Trajet;
import org.projet.projetWeb.repository.TrajetRepository;
import org.springframework.stereotype.Service;

@Service
public class TrajetService {
    private final GoogleService googleService;
    private final TrajetRepository trajetRepository;

    public TrajetService(GoogleService googleService, TrajetRepository trajetRepository) {
        this.googleService = googleService;
        this.trajetRepository = trajetRepository;
    }
    public Trajet createTrajet(Trajet trajet) {
        // Calculate and set latitude and longitude for departure address
        GeocodeResponse departureGeocode = googleService.geocode(trajet.getDepartureAddress());
        if (departureGeocode != null) {
            trajet.setDepartureLatitude(departureGeocode.getResults().get(0).getPosition().getLat());
            trajet.setDepartureLongitude(departureGeocode.getResults().get(0).getPosition().getLon());
        }

        // Calculate and set latitude and longitude for destination address
        GeocodeResponse destinationGeocode = googleService.geocode(trajet.getDestinationAddress());
        if (destinationGeocode != null) {
            trajet.setDestinationLatitude(destinationGeocode.getResults().get(0).getPosition().getLat());
            trajet.setDestinationLongitude(destinationGeocode.getResults().get(0).getPosition().getLon());
        }

        // Save the trajet object with updated latitude and longitude values
        return trajetRepository.save(trajet);
    }
    public Trajet updateTrajet(int trajetId) {
        Trajet trajetToUpdate = trajetRepository.findById(trajetId).orElse(null);
        if (trajetToUpdate != null) {
            // Calculate and set latitude and longitude for departure address
            GeocodeResponse departureGeocode = googleService.geocode(trajetToUpdate.getDepartureAddress());
            if (departureGeocode != null) {
                trajetToUpdate.setDepartureLatitude(departureGeocode.getResults().get(0).getPosition().getLat());
                trajetToUpdate.setDepartureLongitude(departureGeocode.getResults().get(0).getPosition().getLon());
            }

            // Calculate and set latitude and longitude for destination address
            GeocodeResponse destinationGeocode = googleService.geocode(trajetToUpdate.getDestinationAddress());
            if (destinationGeocode != null) {
                trajetToUpdate.setDestinationLatitude(destinationGeocode.getResults().get(0).getPosition().getLat());
                trajetToUpdate.setDestinationLongitude(destinationGeocode.getResults().get(0).getPosition().getLon());
            }

            // Save the updated trajet object with latitude and longitude values
            return trajetRepository.save(trajetToUpdate);
        } else {
            // Handle case where trajet with given ID is not found
            return null;
        }
    }
}
