package org.projet.projetWeb.repository;

import org.projet.projetWeb.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JourneyRepository extends JpaRepository<Journey, Integer> {

    Optional<Journey> findTopByDriverUserIDOrderByJourneyCreationDateDesc( int userID);
    @Query("SELECT j FROM Journey j WHERE " +
            "j.trajet.departureAddress = :departureAddress AND " +
            "j.trajet.destinationAddress = :destinationAddress")
    List<Journey> findDriversWithinDistance(@Param("departureAddress") String departureAddress,
                                            @Param("destinationAddress") String destinationAddress);
}
