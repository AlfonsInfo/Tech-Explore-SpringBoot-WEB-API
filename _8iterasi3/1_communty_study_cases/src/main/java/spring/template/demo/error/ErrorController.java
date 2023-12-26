package spring.template.demo.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.template.demo.entities.dto.BaseResponse;
import spring.template.demo.entities.dto.ErrorSchema;
import spring.template.demo.repository.ErrorRepository;
import spring.template.demo.utils.exception.CustomException;
import spring.template.demo.utils.exception.CustomValidationException;

import java.util.Locale;
import java.util.Objects;

@RestControllerAdvice
public class ErrorController {

    @Autowired
    MessageSource messageSource;


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> customExceptionHandling(CustomException customException)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("error test");
    }


    @ExceptionHandler(CustomValidationException.class)
    public BaseResponse validationExceptionHandling (CustomValidationException validationException, Locale locale)
    {
        ErrorSchema errorSchema = new ErrorSchema();
        String errorMessage = messageSource.getMessage("error.message",null,locale);
        if(Objects.equals(locale.getLanguage(), Locale.US.getLanguage())){
            errorMessage = validationException.getMessage();
        }

        //SET ERROR SCHEMA VALUES
        errorSchema.setErrorCode("400");
        errorSchema.setErrorMessage(errorMessage);

        return BaseResponse
                .builder()
                .errorSchema(errorSchema)
                .build();
    }
}
