package org.projet.projetWeb.repository;

import org.projet.projetWeb.model.Journey;
import org.projet.projetWeb.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JourneyRepository extends JpaRepository<Journey, Integer> {

    Optional<Journey> findTopByDriverUserIDOrderByJourneyCreationDateDesc( int userID);
    Optional<Journey> findJourneyByTrajet_TrajetID(int trajetID);
    List<Journey> findJourneysByTrajet(Trajet trajet);
    @Query("SELECT j FROM Journey j " +
            "JOIN j.driver u " +
            "WHERE j.trajet.departureAddress = :departureAddress " +
            "AND j.trajet.destinationAddress = :destinationAddress " +
            "AND u.role = 'Driver'")
    List<Journey> findDriversWithinDistance(@Param("departureAddress") String departureAddress,
                                            @Param("destinationAddress") String destinationAddress);
}
