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

    // TODO: Implement a method to handle PUT requests at the /recipes/{id} endpoint.
    // This method should take in a UUID path variable for the recipe ID and a RecipeItem object
    // from the request body. Find the existing recipe by its ID, update its title and description 
    // with the provided details, use the recipeRepository to save the updated recipe, 
    // and return the updated RecipeItem.
    @PutMapping("/recipes/{id}")
    public RecipeItem updateRecipe(@PathVariable UUID id, @RequestBody RecipeItem updatedRecipe) {
        RecipeItem existingRecipe = recipeRepository.findById(id);
        if (existingRecipe == null) {
            throw new RuntimeException("Recipe not found!");
        }
        existingRecipe.setTitle(updatedRecipe.getTitle());
        existingRecipe.setDescription(updatedRecipe.getDescription());
        recipeRepository.save(existingRecipe);
        return existingRecipe;
    }
}