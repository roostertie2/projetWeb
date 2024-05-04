package org.projet.projetWeb.repository;

import org.projet.projetWeb.model.Journey;
import org.projet.projetWeb.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository  extends JpaRepository<Reservation, Integer> {
    Optional<Reservation> findReservationByJourney_JourneyID(int JourneyID);
    List<Reservation> findReservationsByJourney(Journey journey);
}
