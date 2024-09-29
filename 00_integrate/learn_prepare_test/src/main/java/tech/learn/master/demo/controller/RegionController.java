package tech.learn.master.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.learn.master.demo.domain.dto.city.CityUpsertRequestDto;
import tech.learn.master.demo.domain.dto.city.SimpleCityResponseDto;
import tech.learn.master.demo.domain.dto.province.ProvinceUpsertRequestDto;
import tech.learn.master.demo.domain.dto.province.ProvinceResponseDto;
import tech.learn.master.demo.domain.dto.schema.ResMessageDto;
import tech.learn.master.demo.exception.DataNotFoundException;
import tech.learn.master.demo.service.CityService;
import tech.learn.master.demo.service.ProvinceService;
import tech.learn.master.demo.service.RegionService;
import tech.learn.master.demo.validator.constraint.ProvinceIsFound;
import tech.learn.master.demo.validator.group.PostGroupValidation;
import tech.learn.master.demo.validator.group.PutGroupValidation;

@RestController
@RequestMapping("/api/v1/regions")
public class RegionController {

    //service
    private final RegionService regionService;
    private final ProvinceService provinceService;
    private final CityService cityService;

    @Autowired
    public RegionController(RegionService regionService, ProvinceService provinceService, CityService cityService) {
        this.regionService = regionService;
        this.provinceService = provinceService;
        this.cityService = cityService;
    }

    @PostMapping("/provinces")
    @ResponseStatus(HttpStatus.CREATED)
    public ResMessageDto<ProvinceResponseDto> createProvince(
           @Validated(PostGroupValidation.class) @RequestBody ProvinceUpsertRequestDto provinceUpdateDto
    ) {
        ProvinceResponseDto responseDto = provinceService.createProvince(provinceUpdateDto);
        return ResMessageDto
                .<ProvinceResponseDto>builder() 
                .code(201)
                .message("Province created successfully")
                .data(responseDto)
                .build();
    }

    @GetMapping("/provinces")
    public Page<ProvinceResponseDto> getProvinces(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "false" ) Boolean includeCities
    ) {
        return provinceService.getAllProvinces(page, size,includeCities);
    }

    @GetMapping("/provinces/{provinceId}")
    public ResMessageDto<ProvinceResponseDto> getProvinceById(@PathVariable @ProvinceIsFound Long provinceId)
            throws DataNotFoundException
    {
        ProvinceResponseDto responseDto = provinceService.getProvinceById(provinceId);
        return ResMessageDto
                .<ProvinceResponseDto>builder()
                .code(200)
                .message("Province retrieved successfully")
                .data(responseDto)
                .build();
    }

    @PutMapping("/provinces")
    @ResponseStatus(HttpStatus.OK)
    public ResMessageDto<ProvinceResponseDto> updateProvinces(
            @Validated(PutGroupValidation.class) @RequestBody ProvinceUpsertRequestDto provinceUpdateDto
    ) {
        ProvinceResponseDto responseDto = provinceService.updateProvince(provinceUpdateDto);
        return ResMessageDto
                .<ProvinceResponseDto>builder()
                .code(200)
                .message("Province updated successfully")
                .data(responseDto)
                .build();
    }

    @DeleteMapping("/provinces/{provinceId}")
    @ResponseStatus(HttpStatus.OK)
    public ResMessageDto<ProvinceResponseDto> deleteProvinceById(@PathVariable  @ProvinceIsFound Long provinceId) {
        provinceService.deleteProvinceById(provinceId);
        return ResMessageDto
                .<ProvinceResponseDto>builder()
                .code(204)
                .message("Province deleted successfully")
                .build();
    }

    @PostMapping("cities")
    @ResponseStatus(HttpStatus.CREATED)
    public ResMessageDto<SimpleCityResponseDto> createCity(
            @Validated(PostGroupValidation.class) @RequestBody CityUpsertRequestDto requestBody
    ) {
        SimpleCityResponseDto responseDto = cityService.createCity(requestBody);
        return ResMessageDto
                .<SimpleCityResponseDto>builder()
                .code(201)
                .message("City created successfully")
                .data(responseDto)
                .build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResMessageDto<SimpleCityResponseDto> updateCity(
            @Validated(PutGroupValidation.class) @RequestBody CityUpsertRequestDto requestBody
    ) {
        SimpleCityResponseDto responseDto = cityService.updateCity(requestBody);
        return ResMessageDto
                .<SimpleCityResponseDto>builder()
                .code(200)
                .message("City updated successfully")
                .data(responseDto)
                .build();
    }

    @GetMapping("/provinces/{provinceId}/cities")
    public Page<SimpleCityResponseDto> getCitiesByProvinceId(
            @PathVariable @ProvinceIsFound Long provinceId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return cityService.getCitiesByProvinceId(provinceId, page, size);
    }



}
