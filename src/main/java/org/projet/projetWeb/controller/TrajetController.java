package org.projet.projetWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.projet.projetWeb.model.Journey;
import org.projet.projetWeb.model.Reservation;
import org.projet.projetWeb.model.Trajet;
import org.projet.projetWeb.repository.JourneyRepository;
import org.projet.projetWeb.repository.ReservationRepository;
import org.projet.projetWeb.repository.TrajetRepository;
import org.projet.projetWeb.services.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/trajets")
public class TrajetController {
    @Autowired
    TrajetRepository trajetRepository;
    @Autowired
    JourneyRepository journeyRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    TrajetService trajetService;
    @GetMapping("/findTrajetById/{id}")
    public ResponseEntity<Trajet> getTrajetById(@PathVariable int id) {
        Optional<Trajet> trajetOptional = trajetRepository.findById(id);
        return trajetOptional.map(journey -> ResponseEntity.ok().body(journey))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/findTrajetsByUserId/{id}")
    public ResponseEntity<List<Trajet>> getTrajetsByUserId(@PathVariable int id) {
        List<Trajet> listTrajet = trajetRepository.findTrajetByUser_userID(id);
        return  ResponseEntity.ok().body(listTrajet);
    }
    @GetMapping("/findAllTrajet")
    public ResponseEntity<List<Trajet>> getAllTrajet() {
        List<Trajet> listTrajet= trajetRepository.findAll();
       return ResponseEntity.ok().body(listTrajet);
    }
    @PostMapping("/create")
    public ResponseEntity<Trajet> createTrajet(@RequestBody Trajet trajet) {
        Trajet createdTrajet = trajetService.createTrajet(trajet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrajet);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Trajet> updateTrajet(@PathVariable int id, @RequestBody Trajet updatedTrajet) {
        if (!trajetRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedTrajet.setTrajetID(id);
        Trajet savedJourney = trajetRepository.save(updatedTrajet);
        return ResponseEntity.ok().body(savedJourney);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrajet(@PathVariable int id) {
        Optional<Trajet> trajetOptional = trajetRepository.findById(id);
        if (trajetOptional.isPresent()) {
            Trajet trajet = trajetOptional.get();

            // Find all associated journeys for the trajet
            List<Journey> journeys = journeyRepository.findJourneysByTrajet(trajet);

            // Loop through each journey and delete associated reservations
            for (Journey journey : journeys) {
                List<Reservation> reservations = reservationRepository.findReservationsByJourney(journey);
                reservationRepository.deleteAll(reservations);
            }

            // Delete all associated journeys
            journeyRepository.deleteAll(journeys);

            // Delete the trajet itself
            trajetRepository.delete(trajet);

            return ResponseEntity.ok("Trajet and associated journeys and reservations deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Trajet not found with ID: " + id);
        }
    }

}
