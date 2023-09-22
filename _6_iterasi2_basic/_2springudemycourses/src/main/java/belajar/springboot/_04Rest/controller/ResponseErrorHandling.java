package belajar.springboot._04Rest.controller;


import belajar.springboot._04Rest.entity.CustomErrorResponse;
import belajar.util.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;


@RestControllerAdvice // ControllerAdvice
public class ResponseErrorHandling {

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

}
