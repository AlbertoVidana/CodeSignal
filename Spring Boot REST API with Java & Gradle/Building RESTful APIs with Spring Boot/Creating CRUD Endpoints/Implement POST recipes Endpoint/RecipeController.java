package com.codesignal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public List<RecipeItem> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // TODO: Implement a method to handle POST requests at the /recipes endpoint.
    // This method should take in a RecipeItem object from the request body,
    // use the recipeRepository to save it, and return the saved RecipeItem.
    @PostMapping("/recipes")
    public RecipeItem addRecipe(@RequestBody RecipeItem recipeItem) {
        recipeRepository.save(recipeItem);
        return recipeItem;
    }
}