package org.projet.projetWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "DaysOfWeek")
public class DaysOfWeek {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "DayID")
    private int dayID;
    @NotBlank(message = "Day name cannot be blank")
    @Size(max = 20, message = "Day name must not exceed 20 characters")
    private String dayName;

}
