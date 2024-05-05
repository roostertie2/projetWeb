package org.projet.projetWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "RatingID")
    private int ratingID;
    @NotNull(message = "Score is required")
    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be no more than 5")
    @Column(name = "Score")
    private int score;

    @NotNull(message = "Rating date is required")
    @Column(name = "RatingDate")
    private LocalDateTime ratingDate;

    @Size(max = 1024, message = "Comment must be no more than 1024 characters")
    @Column(name = "Comment", columnDefinition = "TEXT")
    private String comment;

    @NotNull(message = "Rater is required")
    @ManyToOne
    @JoinColumn(name = "RaterID", referencedColumnName = "userID")
    private User rater;

    @NotNull(message = "Rated user is required")
    @ManyToOne
    @JoinColumn(name = "RatedID", referencedColumnName = "userID")
    private User rated;
}
