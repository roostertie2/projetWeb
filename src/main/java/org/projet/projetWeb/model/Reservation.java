package org.projet.projetWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "reservationID")
    private int reservationID;
    @NotNull(message = "Reservation date is required")
    @Column(name = "ReservationDate")
    private LocalDateTime reservationDate;

    @NotNull(message = "Reservation status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "ReservationStatus")
    private ReservationStatus reservationStatus;

    @NotNull(message = "Passenger is required")
    @ManyToOne
    @JoinColumn(name = "PassengerID", referencedColumnName = "userID")
    private User passenger;

    @NotNull(message = "Journey is required")
    @ManyToOne
    @JoinColumn(name = "JourneyID", referencedColumnName = "JourneyID")
    private Journey journey;
    public enum ReservationStatus {
        Confirmed, Pending, Cancelled
    }
}
