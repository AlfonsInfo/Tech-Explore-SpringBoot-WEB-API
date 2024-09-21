package tech.learn.master.demo.domain.dto.province;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.learn.master.demo.validator.constraint.ProvinceIsFound;
import tech.learn.master.demo.validator.constraint.ProvinceIsUnique;
import tech.learn.master.demo.validator.group.PostGroupValidation;
import tech.learn.master.demo.validator.group.PutGroupValidation;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ProvinceIsUnique (groups = {PostGroupValidation.class,PutGroupValidation.class})
public class ProvinceUpsertDto {

    @NotNull(groups = {PutGroupValidation.class})
    @ProvinceIsFound(groups = {PutGroupValidation.class})
    private Long provinceId;

    @NotNull(groups = {
            PostGroupValidation.class,
            PutGroupValidation.class
    })

    private String provinceName;
}
