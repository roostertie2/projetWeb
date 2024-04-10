package org.projet.projetWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "UserID")
    private int userID;
    @NotBlank(message = "le nom ne peut pas etre vide")
    private String lastName;
    @NotBlank(message = "le nom ne peut pas etre vide")
    private String firstName;
    @NotBlank(message = "le nom peut pas etre vide")
    @Pattern(regexp = "^[+]?[0-9]{10,13}$", message = "Format de téléphone invalide")
    private String telephone;
    @NotNull(message = "La date de naissance ne peut pas être nulle")
    @Past(message = "La date de naissance doit être dans le passé")
    private LocalDate dateOfBirth;
    @NotNull(message = "Le sexe est requis")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank(message = "L'email ne peut pas être vide")
    @Email(message = "Format de l'email invalide")
    private String email;

    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Le mot de passe doit contenir au moins 8 caractères, dont une majuscule, une minuscule, un chiffre et un caractère spécial")
    private String hashedPassword;

    @NotNull(message = "La date d'inscription ne peut pas être nulle")
    private LocalDateTime registrationDate;

    @NotBlank(message = "La langue préférée ne peut pas être vide")
    private String preferredLanguage;

    private String profession;

    @Lob
    private String hobbiesInterests;

    private String emergencyContact;

    private String profilePhoto;

    @NotNull(message = "Les préférences de notification sont requises")
    @Enumerated(EnumType.STRING)
    private NotificationPreferences notificationPreferences;

    @NotNull(message = "L'état actif est requis")
    private Boolean isActive;

    @NotNull(message = "Le rôle est requis")
    @Enumerated(EnumType.STRING)
    private Role role;

    enum Gender {
        Male, Female, Other
    }

    enum NotificationPreferences {
        Email, SMS, Push_Notification
    }

    enum Role {
        Driver, Passenger
    }
}
