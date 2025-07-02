package com.codesignal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public List<RecipeItem> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @PostMapping("/recipes")
    public RecipeItem addRecipe(@RequestBody RecipeItem recipeItem) {
        recipeRepository.save(recipeItem);
        return recipeItem;
    }

    @PutMapping("/recipes/{id}")
    public RecipeItem updateRecipe(@PathVariable UUID id, @RequestBody RecipeItem recipeItem) {
        RecipeItem existingRecipe = recipeRepository.findById(id);
        if (existingRecipe != null) {
            existingRecipe.setTitle(recipeItem.getTitle());
            existingRecipe.setDescription(recipeItem.getDescription());
            recipeRepository.save(existingRecipe);
        }
        return existingRecipe;
    }
  
    // TODO: Implement a method to handle DELETE requests at the /recipes/{id} endpoint.
    // This method should take in a UUID path variable for the recipe ID. Find the existing recipe by its ID,
    // use the recipeRepository to delete the recipe, and return an appropriate response.
    @DeleteMapping("/recipes/{id}")
    public String deleteRecipe(@PathVariable UUID id) {
        RecipeItem recipe = recipeRepository.findById(id);
        if (recipe == null) {
            throw new RuntimeException("Recipe not found!");
        }
        recipeRepository.delete(id);
        return "Recipe deleted!";
    }
}