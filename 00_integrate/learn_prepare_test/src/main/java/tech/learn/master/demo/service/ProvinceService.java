package tech.learn.master.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import tech.learn.master.demo.domain.dto.province.ProvinceUpsertDto;
import tech.learn.master.demo.domain.dto.province.ProvinceResponseDto;
import tech.learn.master.demo.domain.entity.Province;
import tech.learn.master.demo.mapper.ProvinceMapper;
import tech.learn.master.demo.repository.ProvinceRepository;

@Service
public class ProvinceService {

    //repository
    private ProvinceRepository provinceRepository;

    //mapper
    private ProvinceMapper provinceMapper;

    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository, ProvinceMapper provinceMapper) {
        this.provinceRepository = provinceRepository;
        this.provinceMapper = provinceMapper;
    }

    public ProvinceResponseDto createProvince(ProvinceUpsertDto provinceCreateDto) {
        Province provinceEntity = provinceMapper.provinceCreateDtoToProvince(provinceCreateDto);
        provinceRepository.save(provinceEntity);
        return provinceMapper.provinceToProvinceResponseDto(provinceEntity);
    }

    public ProvinceResponseDto updateProvince(ProvinceUpsertDto provinceUpdateDto){
        Province provinceEntity = provinceMapper.provinceCreateDtoToProvince(provinceUpdateDto);
        provinceRepository.save(provinceEntity);
        return provinceMapper.provinceToProvinceResponseDto(provinceEntity);
    }



    public ProvinceResponseDto getProvinceById(Long id) {
        return null;
    }

    public Page<ProvinceResponseDto> getAllProvinces(int page, int size) {
        return null;
    }



}
