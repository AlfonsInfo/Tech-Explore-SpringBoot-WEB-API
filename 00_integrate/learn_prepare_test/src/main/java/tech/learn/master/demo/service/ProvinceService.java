package tech.learn.master.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tech.learn.master.demo.domain.dto.province.ProvinceUpsertRequestDto;
import tech.learn.master.demo.domain.dto.province.ProvinceResponseDto;
import tech.learn.master.demo.domain.entity.Province;
import tech.learn.master.demo.exception.DataNotFoundException;
import tech.learn.master.demo.mapper.CityMapper;
import tech.learn.master.demo.mapper.ProvinceMapper;
import tech.learn.master.demo.repository.ProvinceRepository;

@Service
public class ProvinceService {

    //repository
    private ProvinceRepository provinceRepository;

    //mapper
    private ProvinceMapper provinceMapper;
    private CityMapper cityMapper;

    @Autowired
    public ProvinceService(
            ProvinceRepository provinceRepository,
            ProvinceMapper provinceMapper,
            CityMapper cityMapper
    ) {
        this.provinceRepository = provinceRepository;
        this.provinceMapper = provinceMapper;
        this.cityMapper = cityMapper;
    }

    public ProvinceResponseDto createProvince(ProvinceUpsertRequestDto provinceCreateDto) {
        Province provinceEntity = provinceMapper.provinceCreateDtoToProvince(provinceCreateDto);
        provinceRepository.save(provinceEntity);
        return provinceMapper.provinceToProvinceResponseDto(provinceEntity);
    }

    public ProvinceResponseDto updateProvince(ProvinceUpsertRequestDto provinceUpdateDto){
        Province provinceEntity = provinceMapper.provinceCreateDtoToProvince(provinceUpdateDto);
        provinceRepository.save(provinceEntity);
        return provinceMapper.provinceToProvinceResponseDto(provinceEntity);
    }



    public ProvinceResponseDto getProvinceById(
         Long id
    ) throws DataNotFoundException {
        Province province = provinceRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Province not found"));
        return provinceMapper.provinceToProvinceResponseDto(province);
    }

    public Page<ProvinceResponseDto> getAllProvinces(int page, int size, Boolean includeCities) {
        if(Boolean.TRUE.equals(includeCities)){ return provinceRepository.findAll(PageRequest.of(page, size)).map(province -> provinceMapper.provinceToProvinceResponseDtoWithCities(province, true,cityMapper));}
        return provinceRepository.findAll(PageRequest.of(page, size)).map(provinceMapper::provinceToProvinceResponseDto);
    }

    public void deleteProvinceById(
            Long id
    ) {
        provinceRepository.deleteById(id);
    }


}
