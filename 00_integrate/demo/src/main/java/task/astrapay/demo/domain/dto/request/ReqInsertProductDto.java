package task.astrapay.demo.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReqInsertProductDto {
    @NotNull @NotBlank
    private String title;
    @NotNull @NotBlank
    private String description;
    @NotNull
    private Integer categoryId;
    @NotNull @NotBlank
    private Double Rating;
    @NotNull @NotBlank
    private Integer stock;
    @NotNull @NotBlank
    private List<String> arrayTagId = new ArrayList<>();
}
