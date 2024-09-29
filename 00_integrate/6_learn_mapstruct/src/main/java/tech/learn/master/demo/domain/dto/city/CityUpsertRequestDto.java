package tech.learn.master.demo.domain.dto.city;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.learn.master.demo.validator.constraint.CityIsFound;
import tech.learn.master.demo.validator.constraint.ProvinceIsFound;
import tech.learn.master.demo.validator.constraint.ProvinceIsUnique;
import tech.learn.master.demo.validator.group.PostGroupValidation;
import tech.learn.master.demo.validator.group.PutGroupValidation;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ProvinceIsUnique (groups = {PostGroupValidation.class,PutGroupValidation.class})
public class CityUpsertRequestDto {
    @NotNull(groups = {PutGroupValidation.class})
    @CityIsFound(groups = {PutGroupValidation.class})
    private Long cityId;
    @NotNull(groups = {PostGroupValidation.class,PutGroupValidation.class})
    private String cityName;
    @ProvinceIsFound(groups = {PutGroupValidation.class})
    private Long provinceId;
}
