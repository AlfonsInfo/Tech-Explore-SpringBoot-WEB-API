package tech.learn.master.demo.validator.constraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import tech.learn.master.demo.validator.ProvinceIsUniqueValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProvinceIsUniqueValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProvinceIsUnique {
    String message() default "Province name must be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
