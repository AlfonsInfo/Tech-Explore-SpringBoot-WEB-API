package tech.learn.master.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.learn.master.demo.domain.dto.province.ProvinceUpsertDto;
import tech.learn.master.demo.domain.dto.province.ProvinceResponseDto;
import tech.learn.master.demo.domain.entity.Province;

@Mapper(componentModel = "spring")
public interface ProvinceMapper {
    @Mapping(source = "provinceId", target = "id")
    Province provinceCreateDtoToProvince(ProvinceUpsertDto provinceCreate);
    ProvinceResponseDto provinceToProvinceResponseDto(Province province);
}
