package org.projet.projetWeb.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.projet.projetWeb.validations.PasswordStrengthValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {

    String message() default "Veuillez choisir un mot de passe solide.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
