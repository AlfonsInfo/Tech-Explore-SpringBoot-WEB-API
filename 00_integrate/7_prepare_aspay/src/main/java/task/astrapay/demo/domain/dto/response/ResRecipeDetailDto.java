package task.astrapay.demo.domain.dto.response;

import java.util.ArrayList;
import java.util.List;

public class ResRecipeDetailDto {
    public Integer id;
    public String name;
    public List<String> ingredient = new ArrayList<>();
    public List<String> instructions = new ArrayList<>();
    public Integer prepTimeMinutes;
    public Integer cookTimeMinutes;
    public Integer servings;
    public String difficulty;
    public String cuisine;
    public Integer caloriesPerServing;
    public List<String> tags = new ArrayList<>();
    public Integer userId;
    public String image;
    public Integer rating;
    public Integer reviewCount;
    public List<String> mealType = new ArrayList<>();
}
