package org.projet.projetWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Trajets")
public class Trajet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "TrajetID")
    private int trajetID;
    @NotBlank(message = "Departure address cannot be blank")
    @Column(name = "DepartureAddress", length = 255)
    private String departureAddress;

    @NotBlank(message = "Destination address cannot be blank")
    @Column(name = "DestinationAddress", length = 255)
    private String destinationAddress;

    @NotNull(message = "Desired departure time is required")
    @Column(name = "DesiredDepartureTime")
    private LocalDateTime desiredDepartureTime;

    @Column(name = "DesiredArrivalTime")
    private LocalDateTime desiredArrivalTime;

    @NotNull(message = "User ID is required")
    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "userID")
    private User user;

    @NotNull(message = "Day ID is required")
    @ManyToOne
    @JoinColumn(name = "DayID", referencedColumnName = "DayID")
    private DaysOfWeek day;

    @Column(name = "DepartureLatitude")
    private Double departureLatitude;

    @Column(name = "DepartureLongitude")
    private Double departureLongitude;

    @Column(name = "DestinationLatitude")
    private Double destinationLatitude;

    @Column(name = "DestinationLongitude")
    private Double destinationLongitude;
}
