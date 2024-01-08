package spring.template.demo.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.template.demo.common.exception.CustomValidationException;

import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class CommonValidator {


    private final Validator validator;

    @Autowired
    public CommonValidator(Validator validator){
        this.validator = validator;
    }
    public void validate(Object request){
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(request);
        if(!constraintViolationSet.isEmpty()){
            Optional<ConstraintViolation<Object>> firstError = constraintViolationSet.stream().findFirst();
            String property =  firstError.get().getPropertyPath().toString();
            String message = firstError.get().getMessage();
            throw new CustomValidationException(property, message);
        }
    }
}
