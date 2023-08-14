package restfulAPI.restful.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restfulAPI.restful.dto.request.RegisterUserRequest;

import java.util.Set;


@Service
public class ValidationService {


//    @Autowired // kenapa tidak dilakukan di controller ?
//    private Validator validator; // Karena beberapa hal tidak bisa divalidasi body nya

    @Autowired
    private Validator validator;

    public void validate(Object request)
    {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if(constraintViolations.size() != 0)
        {
            throw  new ConstraintViolationException(constraintViolations);
        }
    }
}
