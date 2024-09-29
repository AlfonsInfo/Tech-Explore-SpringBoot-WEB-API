package task.astrapay.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.astrapay.demo.domain.dto.response.ResConsumeRecipeDto;
import task.astrapay.demo.rest.RecipeClient;

@RestController
@RequestMapping("rest/v1/recipes")
public class RecipeController {
    private final RecipeClient recipeClient;

    @Autowired
    public RecipeController(RecipeClient recipeClient) {
        this.recipeClient = recipeClient;
    }

    ResConsumeRecipeDto getListRecipe(){
//        return recipeClient.getAllRecipes();
        return new ResConsumeRecipeDto();
    }
}
