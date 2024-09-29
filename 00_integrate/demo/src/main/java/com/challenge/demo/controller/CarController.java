package com.challenge.demo.controller;

import com.challenge.demo.domain.dto.request.ReqCreateCar;
import com.challenge.demo.domain.dto.response.ResMessageDto;
import com.challenge.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    ResMessageDto<Object> createCar(@RequestBody ReqCreateCar request) {
        return carService.createCar(request);
    }
}
