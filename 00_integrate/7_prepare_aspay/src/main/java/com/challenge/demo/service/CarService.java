package com.challenge.demo.service;

import com.challenge.demo.domain.dto.request.ReqCreateCar;
import com.challenge.demo.domain.dto.response.ResMessageDto;
import com.challenge.demo.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private CarRepository carRepository;

    public ResMessageDto<Object> createCar(ReqCreateCar request) {

        return ResMessageDto.builder().build();
    }
}
