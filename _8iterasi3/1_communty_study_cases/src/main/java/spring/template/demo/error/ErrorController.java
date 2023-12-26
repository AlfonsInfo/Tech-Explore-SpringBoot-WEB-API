package spring.template.demo.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.template.demo.entities.dto.BaseResponse;
import spring.template.demo.entities.dto.ErrorMessageResponse;
import spring.template.demo.entities.dto.ErrorSchema;
import spring.template.demo.repository.ErrorRepository;
import spring.template.demo.utils.exception.CustomException;
import spring.template.demo.utils.exception.CustomValidationException;

@RestControllerAdvice
public class ErrorController {

    @Autowired
    ErrorRepository errorRepository;

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> customExceptionHandling(CustomException customException)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("error test");
    }


    @ExceptionHandler(CustomValidationException.class)
    public BaseResponse validationExceptionHandling (CustomValidationException validationException)
    {
        ErrorSchema errorSchema = new ErrorSchema();

        //untuk sementara
        Error error = errorRepository.findById("error").get();
        ErrorMessageResponse errorMessageResponse= new ErrorMessageResponse(error.errIndMsg , validationException.getMessage());

        //SET ERROR SCHEMA VALUES
        errorSchema.setErrorCode("400");
        errorSchema.setErrorMessageResponse(errorMessageResponse);

        return BaseResponse
                .builder()
                .errorSchema(errorSchema)
                .build();
    }
}
