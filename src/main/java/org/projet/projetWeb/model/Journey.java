package org.projet.projetWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Journeys")
public class Journey {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "JourneyID")
    private int journeyID;
    @NotNull(message = "Available seats is required")
    @Min(value = 1, message = "There must be at least one available seat")
    @Column(name = "AvailableSeats")
    private int availableSeats;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(name = "Price")
    private BigDecimal price;

    @NotNull(message = "Journey creation date is required")
    @Column(name = "JourneyCreationDate")
    private LocalDateTime journeyCreationDate;

    @NotNull(message = "Active status is required")
    @Column(name = "IsActive")
    private Boolean isActive;

    @NotNull(message = "Driver is required")
    @ManyToOne
    @JoinColumn(name = "DriverID", referencedColumnName = "userID")
    private User driver;

    @NotNull(message = "Trajet is required")
    @ManyToOne
    @JoinColumn(name = "TrajetID", referencedColumnName = "TrajetID")
    private Trajet trajet;

}
