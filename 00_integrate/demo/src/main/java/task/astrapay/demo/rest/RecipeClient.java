package task.astrapay.demo.rest;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import task.astrapay.demo.domain.dto.response.ResConsumeRecipeDto;


@FeignClient(value = "RecipeClient", url = "https://dummyjson.com/recipes")
public interface  RecipeClient {

    @GetMapping
    String getAllRecipes();
}
