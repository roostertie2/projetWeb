package org.projet.projetWeb.repository;

import org.projet.projetWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndHashedPassword(String email, String HashedPassword);

    //List<User> findDriversWithinDistance(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("distance") double distance);
}
