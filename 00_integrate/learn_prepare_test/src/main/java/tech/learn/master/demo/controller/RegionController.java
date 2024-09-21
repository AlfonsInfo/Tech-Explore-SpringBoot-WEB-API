package tech.learn.master.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.learn.master.demo.domain.dto.province.ProvinceUpsertDto;
import tech.learn.master.demo.domain.dto.province.ProvinceResponseDto;
import tech.learn.master.demo.domain.dto.schema.ResMessageDto;
import tech.learn.master.demo.service.ProvinceService;
import tech.learn.master.demo.service.RegionService;
import tech.learn.master.demo.validator.group.PostGroupValidation;
import tech.learn.master.demo.validator.group.PutGroupValidation;

@RestController
@RequestMapping("/api/v1/regions")
public class RegionController {

    //service
    private final RegionService regionService;
    private final ProvinceService provinceService;

    @Autowired
    public RegionController(RegionService regionService, ProvinceService provinceService) {
        this.regionService = regionService;
        this.provinceService = provinceService;
    }

    @PostMapping("/provinces")
    @ResponseStatus(HttpStatus.CREATED)
    public ResMessageDto<ProvinceResponseDto> createProvince(
           @Validated(PostGroupValidation.class) @RequestBody ProvinceUpsertDto provinceUpdateDto
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
            @RequestParam(defaultValue = "10") int size
    ) {
        return provinceService.getAllProvinces(page, size);
    }

    @PutMapping("/provinces")
    @ResponseStatus(HttpStatus.OK)
    public ResMessageDto<ProvinceResponseDto> updateProvinces(
            @Validated(PutGroupValidation.class) @RequestBody ProvinceUpsertDto provinceUpdateDto
    ) {
        ProvinceResponseDto responseDto = provinceService.updateProvince(provinceUpdateDto);
        return ResMessageDto
                .<ProvinceResponseDto>builder()
                .code(200)
                .message("Province updated successfully")
                .data(responseDto)
                .build();
    }

}
