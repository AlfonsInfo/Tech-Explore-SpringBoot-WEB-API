package tech.learn.master.demo.validator.constraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import tech.learn.master.demo.validator.CityIsFoundValidator;
import tech.learn.master.demo.validator.ProvinceIsFoundValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CityIsFoundValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CityIsFound {
    String message() default "City id not found";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
