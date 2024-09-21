package tech.learn.master.demo.domain.dto.province;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProvinceResponseDto {
    private Long id;
    private String provinceName;
}
