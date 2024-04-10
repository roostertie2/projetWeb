package org.projet.projetWeb.repository;

import org.projet.projetWeb.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository  extends JpaRepository<Car, Integer> {
}
