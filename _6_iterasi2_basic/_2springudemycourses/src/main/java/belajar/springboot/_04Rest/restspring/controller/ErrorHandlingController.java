package belajar.springboot._04Rest.restspring.controller;


import belajar.springboot._04Rest.restspring.entity.CustomErrorResponse;
import belajar.springboot._04Rest.restspring.util.exception.CreateCollegeException;
import belajar.util.exception.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice // ControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(EntityNotFoundException.class)
    public CustomErrorResponse handlingEntityNotFound()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        return CustomErrorResponse.builder()
                .message("Data tidak ditemukan")
                .status(HttpStatus.NOT_FOUND.toString())
                .timeStamp(System.currentTimeMillis())
//                .timeStamp(currentTime.toEpochSecond(ZoneOffset.UTC))
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomErrorResponse> handlingConstraintViolation(ConstraintViolationException exception)
    {
        CustomErrorResponse customErrorResponse = CustomErrorResponse
                .builder()
                .message("Gimana si bang ? ")
                .timeStamp(System.currentTimeMillis())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();
        return new ResponseEntity<CustomErrorResponse>(customErrorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CreateCollegeException.class)
    public ResponseEntity<CustomErrorResponse> handlingCreateCollegeException(CreateCollegeException exception)
    {
        CustomErrorResponse customErrorResponse = CustomErrorResponse
                .builder()
                .message(exception.getMessage())
                .timeStamp(System.currentTimeMillis())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();
        return new ResponseEntity<CustomErrorResponse>(customErrorResponse,HttpStatus.BAD_REQUEST);
    }

}
