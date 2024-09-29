package tech.learn.master.demo.mapper;

import org.mapstruct.Mapper;
import tech.learn.master.demo.domain.dto.city.CityUpsertRequestDto;
import tech.learn.master.demo.domain.dto.city.SimpleCityResponseDto;
import tech.learn.master.demo.domain.entity.City;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
        List<SimpleCityResponseDto> citiesToCityResponseDtos(List<City> cities);
        City cityUpsertRequestDtoToCity(CityUpsertRequestDto requestDto);
        SimpleCityResponseDto cityToCityResponseDto(City city);
}
