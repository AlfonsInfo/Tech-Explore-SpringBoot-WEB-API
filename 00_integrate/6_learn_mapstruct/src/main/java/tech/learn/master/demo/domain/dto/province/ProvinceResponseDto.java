package tech.learn.master.demo.domain.dto.province;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.learn.master.demo.domain.dto.city.SimpleCityResponseDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProvinceResponseDto {
    private Long id;
    private String provinceName;
    private List<SimpleCityResponseDto> cities;
}
