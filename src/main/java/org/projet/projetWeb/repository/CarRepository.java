package org.projet.projetWeb.repository;

import org.projet.projetWeb.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository  extends JpaRepository<Car, Integer> {
    Optional<Car> findCarByDriverId(int driverId);
}
