package com.challenge.demo.domain.dto.request;

import com.challenge.demo.domain.TransmissionType;
import jakarta.validation.constraints.NotBlank;

public class ReqCreateCar {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private Long price;
    @NotBlank
    private Long brandId;
    @NotBlank
    private Integer year;
    @NotBlank
    private String color;
    private Integer mileage;
    private String status;
    private Integer seatingCapacity;
}
