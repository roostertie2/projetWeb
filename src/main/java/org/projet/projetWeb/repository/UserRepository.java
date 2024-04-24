package org.projet.projetWeb.repository;

import org.projet.projetWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndHashedPassword(String email, String HashedPassword);
}
