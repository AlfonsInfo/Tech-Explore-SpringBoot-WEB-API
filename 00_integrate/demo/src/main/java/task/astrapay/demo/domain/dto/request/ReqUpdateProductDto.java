package task.astrapay.demo.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReqUpdateProductDto {
    @NotNull
    private Integer id;
    @NotNull @NotBlank
    private String title;
    @NotNull @NotBlank
    private String description;
    @NotNull @NotBlank
    private Integer categoryId;
    @NotNull @NotBlank
    private Double Rating;
    @NotNull @NotBlank
    private Integer stock;
    @NotNull @NotBlank
    private List<String> arrayTagId = new ArrayList<>();
}
