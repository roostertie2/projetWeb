package org.projet.projetWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.projet.projetWeb.model.Car;
import org.projet.projetWeb.model.Journey;
import org.projet.projetWeb.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/journeys")
public class JourneyController {
    @Autowired
    JourneyRepository journeyRepository;
    @GetMapping("/findJourneyById/{id}")
    public ResponseEntity<Journey> getJourneyById(@PathVariable int id) {
        Optional<Journey>  journeyOptional = journeyRepository.findById(id);
        return journeyOptional.map(journey -> ResponseEntity.ok().body(journey))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public ResponseEntity<Journey> createJourney(@RequestBody Journey journey) {
        Journey createdJourney = journeyRepository.save(journey);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJourney);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Journey> updateJourney(@PathVariable int id, @RequestBody Journey updatedJourney) {
        if (!journeyRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedJourney.setJourneyID(id);
        Journey savedJourney = journeyRepository.save(updatedJourney);
        return ResponseEntity.ok().body(savedJourney);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJourney(@PathVariable int id) {
        Optional<Journey> journeyOptional = journeyRepository.findById(id);
        if (journeyOptional.isPresent()) {
            Journey journey = journeyOptional.get();
            journeyRepository.delete(journey);
            return ResponseEntity.ok("Journey supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Journey non trouvée avec l'ID : " + id);
        }
    }
}
