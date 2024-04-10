package org.projet.projetWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "CarID")
    private int carID;
    @NotBlank(message = "Brand cannot be blank")
    @Size(max = 100, message = "Brand must not exceed 100 characters")
    private String brand;

    @NotBlank(message = "Model cannot be blank")
    @Size(max = 100, message = "Model must not exceed 100 characters")
    private String model;

    @NotNull(message = "Car year is required")
    @Min(value = 1900, message = "Car year must be valid")
    private Integer carYear;

    @NotBlank(message = "Color cannot be blank")
    @Size(max = 50, message = "Color must not exceed 50 characters")
    private String color;

    @NotBlank(message = "License plate cannot be blank")
    @Size(max = 20, message = "License plate must not exceed 20 characters")
    private String licensePlate;

    @NotBlank(message = "Serial number cannot be blank")
    @Size(max = 50, message = "Serial number must not exceed 50 characters")
    private String serialNumber;

    @NotNull(message = "Number of seats is required")
    @Min(value = 1, message = "Number of seats must be at least 1")
    private Integer numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "DriverID", insertable = false, updatable = false)
    private User driver;


}
