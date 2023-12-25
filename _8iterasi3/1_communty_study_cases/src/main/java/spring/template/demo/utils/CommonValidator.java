package spring.template.demo.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.template.demo.utils.exception.CustomException;

import java.util.Set;

@Service
@Slf4j
public class CommonValidator {

    @Autowired
    private Validator validator;

    public void validate(Object request){
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(request);
        if(!constraintViolationSet.isEmpty()){
            throw new CustomException("error");
        }
    }
}
