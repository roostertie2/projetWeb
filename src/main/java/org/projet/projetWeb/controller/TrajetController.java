package org.projet.projetWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.projet.projetWeb.model.Journey;
import org.projet.projetWeb.model.Trajet;
import org.projet.projetWeb.repository.JourneyRepository;
import org.projet.projetWeb.repository.TrajetRepository;
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
    @GetMapping("/findTrajetById/{id}")
    public ResponseEntity<Trajet> getTrajetById(@RequestParam int id) {
        Optional<Trajet> trajetOptional = trajetRepository.findById(id);
        return trajetOptional.map(journey -> ResponseEntity.ok().body(journey))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/findAllTrajet")
    public ResponseEntity<List<Trajet>> getAllTrajet() {
        List<Trajet> listTrajet= trajetRepository.findAll();
       return ResponseEntity.ok().body(listTrajet);
    }
    @PostMapping("/create")
    public ResponseEntity<Trajet> createTrajet(@RequestBody Trajet trajet) {
        Trajet createdTrajet = trajetRepository.save(trajet);
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
            trajetRepository.delete(trajet);
            return ResponseEntity.ok("Journey supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Journey non trouvée avec l'ID : " + id);
        }
    }
}
