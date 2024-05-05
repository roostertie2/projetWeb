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
@RequestMapping("/reservations")
public class ReservationController {
   @Autowired
   ReservationRepository reservationRepository;
    @GetMapping("/findReservationById/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.map(journey -> ResponseEntity.ok().body(journey))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/findAllReservations")
    public ResponseEntity<List<Reservation>> getAllReservation() {
        List<Reservation> listReservation= reservationRepository.findAll();
        return ResponseEntity.ok().body(listReservation);
    }
    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationRepository.save(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable int id, @RequestBody Reservation updatedReservation) {
        if (!reservationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedReservation.setReservationID(id);
        Reservation savedReservation = reservationRepository.save(updatedReservation);
        return ResponseEntity.ok().body(savedReservation);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable int id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            Reservation trajet = reservationOptional.get();

            reservationRepository.delete(trajet);
            return ResponseEntity.ok("Trajet and associated journeys and reservations deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Trajet not found with ID: " + id);
        }
    }
}
