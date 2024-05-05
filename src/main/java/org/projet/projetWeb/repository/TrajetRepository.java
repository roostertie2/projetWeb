package org.projet.projetWeb.repository;

import org.projet.projetWeb.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrajetRepository extends JpaRepository<Trajet,Integer> {
    List<Trajet> findTrajetByUser_userID(int userID);
}
