package org.projet.projetWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.projet.projetWeb.model.Reservation;
import org.projet.projetWeb.repository.ReservationRepository;
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
    @GetMapping("/findReservationByJourneyId/{JourneyID}")
    public ResponseEntity<Reservation> getReservationByJourneyId(@PathVariable int JourneyID) {
        Optional<Reservation> reservationOptional = reservationRepository.findReservationByJourney_JourneyID(JourneyID);
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
       Optional<Reservation> reservationExists = reservationRepository.findReservationByJourney_JourneyID(reservation.getJourney().getJourneyID());

        // If a reservation already exists, delete it
        if (reservationExists != null) {
            deleteReservationByJourneyId(reservationExists.get().getJourney().getJourneyID());
        }

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
    @DeleteMapping("/delete/{journeyID}")
    public ResponseEntity<String> deleteReservationByJourneyId(@PathVariable int journeyID) {
        Optional<Reservation> reservationOptional = reservationRepository.findReservationByJourney_JourneyID(journeyID);
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            reservationRepository.delete(reservation);
            return ResponseEntity.ok("reservation supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("reservation non trouvée avec l'ID : " + journeyID);
        }
    }
}
