package com.codesignal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping
    public RecipeItem addRecipe(@RequestBody RecipeItem recipeItem) {
        recipeRepository.save(recipeItem);
        return recipeItem;
    }

    @GetMapping
    public List<RecipeItem> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @GetMapping("/{id}")
    public RecipeItem getRecipeById(@PathVariable UUID id) {
        return recipeRepository.findById(id);
    }

    @PutMapping("/{id}")
    public RecipeItem updateRecipe(@PathVariable UUID id, @RequestBody RecipeItem updatedRecipe) {
        RecipeItem existingRecipe = recipeRepository.findById(id);
        if (existingRecipe == null) {
            throw new RuntimeException("Recipe not found!");
        }

        existingRecipe.setTitle(updatedRecipe.getTitle());
        existingRecipe.setDescription(updatedRecipe.getDescription());

        return existingRecipe;
    }

    @DeleteMapping("/{id}")
    public String deleteRecipe(@PathVariable UUID id) {
        RecipeItem recipe = recipeRepository.findById(id);
        if (recipe == null) {
            throw new RuntimeException("Recipe not found!");
        }

        recipeRepository.delete(id);
        return "Recipe deleted!";
    }
}