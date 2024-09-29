package tech.learn.master.demo.validator.constraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import tech.learn.master.demo.validator.ProvinceIsFoundValidator;
import tech.learn.master.demo.validator.ProvinceIsUniqueValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProvinceIsFoundValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProvinceIsFound {
    String message() default "Province id not found";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
