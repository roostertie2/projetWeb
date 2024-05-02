package org.projet.projetWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.projet.projetWeb.model.User;
import org.projet.projetWeb.repository.UserRepository;
import org.projet.projetWeb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/byId")
    public ResponseEntity<User> getUtilisateurById(@RequestParam int id) {
        Optional<User> utilisateurOptional = userRepository.findById(id);
        return utilisateurOptional.map(utilisateur -> ResponseEntity.ok().body(utilisateur))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/byEmail")
    public ResponseEntity<User> getUtilisateurByEmail(@RequestParam String email) {
        Optional<User> utilisateurOptional = userRepository.findByEmail(email);
        return utilisateurOptional.map(utilisateur -> ResponseEntity.ok().body(utilisateur))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/byEmailAndPassword")
    public ResponseEntity<User> getUtilisateurByEmailAndHashedPassword(@RequestParam String email, @RequestParam String hashedPassword) {
        Optional<User> utilisateurOptional = userRepository.findByEmailAndHashedPassword(email,hashedPassword);
        return utilisateurOptional.map(utilisateur -> ResponseEntity.ok().body(utilisateur))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUtilisateur(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);}
        user.setIsActive(true);
        User createdUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUtilisateur(@PathVariable int id, @RequestBody User updatedUtilisateur) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedUtilisateur.setUserID(id);
        User savedUtilisateur = userRepository.save(updatedUtilisateur);
        return ResponseEntity.ok().body(savedUtilisateur);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<String> deleteUtilisateur(@PathVariable int id) {
        boolean success = userService.disableUser(id);
        if (success) {
            return ResponseEntity.ok("Utilisateur désactivé avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur non trouvé avec l'ID : " + id);
        }
    }
}
