package tech.learn.master.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.learn.master.demo.domain.dto.province.ProvinceUpsertRequestDto;
import tech.learn.master.demo.domain.dto.province.ProvinceResponseDto;
import tech.learn.master.demo.domain.entity.Province;

@Mapper(componentModel = "spring")
public interface ProvinceMapper {



    @Mapping(source = "provinceId", target = "id")
    Province provinceCreateDtoToProvince(ProvinceUpsertRequestDto provinceCreate);
    @Mapping(target = "cities", ignore = true)
    ProvinceResponseDto provinceToProvinceResponseDto(Province province);

    default ProvinceResponseDto provinceToProvinceResponseDtoWithCities(
            Province province,
            Boolean includeCities,
            CityMapper cityMapper
    ) {
        ProvinceResponseDto dto = provinceToProvinceResponseDto(province);
        if (Boolean.TRUE.equals(includeCities)) {
            dto.setCities(cityMapper.citiesToCityResponseDtos(province.getCity().stream().toList()));
        }
        return dto;
    }
}
