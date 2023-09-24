package belajar.springboot._04Rest.restspring.validation;

import belajar.springboot._04Rest.restspring.dto.request.CreateCollegeStudentRequest;
import belajar.springboot._04Rest.restspring.exception.CreateCollegeException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;


@Service
@Slf4j
public class ValidationService {
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


    public void validate(CreateCollegeStudentRequest request){
        log.info("Validation Data For Create College");
        isValidField(request.getNamaDepan(), "nama_depan");
//        isValidField(request.getAngkatan(), "angkatan");
        isValidField(request.getJurusan(), "jurusan");
        log.info("End of validation");
    }


    public void isValidField(Object o,String fieldName){
        if(Objects.isNull(o))
            throw new CreateCollegeException(fieldName + " Tidak boleh Null");
        String strValueOfO = (String) o;
        if(strValueOfO.isEmpty())
            throw new CreateCollegeException(fieldName + " Tidak boleh 0 Character");
    }
}
