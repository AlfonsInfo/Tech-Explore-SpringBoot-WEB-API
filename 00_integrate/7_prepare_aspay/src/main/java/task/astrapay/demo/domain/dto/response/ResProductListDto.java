package task.astrapay.demo.domain.dto.response;

import lombok.Data;
import task.astrapay.demo.domain.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResProductListDto {
    private int id;
    private String title;
    private String description;
    private CategoryEntity categoryEntity;
    private Double Rating;
    private Integer Stock;
    private List<String> stags = new ArrayList<>();
}
