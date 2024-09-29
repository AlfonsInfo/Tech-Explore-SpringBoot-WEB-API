package tech.learn.master.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tech.learn.master.demo.domain.dto.city.CityUpsertRequestDto;
import tech.learn.master.demo.domain.dto.city.SimpleCityResponseDto;
import tech.learn.master.demo.domain.entity.City;
import tech.learn.master.demo.exception.DataNotFoundException;
import tech.learn.master.demo.mapper.CityMapper;
import tech.learn.master.demo.repository.CityRepository;

@Service
public class CityService {

    private final CityRepository cityRepository;

    private final CityMapper cityMapper;

    @Autowired
    public CityService(
            CityMapper cityMapper,
            CityRepository cityRepository
    ) {
        this.cityMapper = cityMapper;
        this.cityRepository = cityRepository;
    }


    public SimpleCityResponseDto createCity(CityUpsertRequestDto cityRequestDto) {
        City cityEntity = cityMapper.cityUpsertRequestDtoToCity(cityRequestDto);
        cityRepository.save(cityEntity);
        return cityMapper.cityToCityResponseDto(cityEntity);
    }


    public Page<SimpleCityResponseDto> getAllCities(int page, int size) {
        return cityRepository.findAll(PageRequest.of(page, size)).map(cityMapper::cityToCityResponseDto);
    }

    public SimpleCityResponseDto getCityById(Long id) throws DataNotFoundException {
        City city = cityRepository.findById(id).orElseThrow(() -> new DataNotFoundException("City not found"));
        return cityMapper.cityToCityResponseDto(city);
    }

    public SimpleCityResponseDto updateCity(CityUpsertRequestDto cityRequestDto) {
        City cityEntity = cityMapper.cityUpsertRequestDtoToCity(cityRequestDto);
        cityRepository.save(cityEntity);
        return cityMapper.cityToCityResponseDto(cityEntity);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public Page<SimpleCityResponseDto> getCitiesByProvinceId(Long provinceId, int page, int size) {
        return cityRepository.findAllByProvinceId(provinceId, PageRequest.of(page, size)).map(cityMapper::cityToCityResponseDto);
    }
}
