package com.codesignal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeItem>> getAllRecipes() {
        List<RecipeItem> recipes = recipeRepository.findAll();
        return ResponseEntity.ok(recipes);
    }

    @PostMapping("/recipes")
    public ResponseEntity<RecipeItem> addRecipe(@RequestBody RecipeItem recipeItem) {
        recipeRepository.save(recipeItem);
        return ResponseEntity.status(201).body(recipeItem);
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<RecipeItem> updateRecipe(@PathVariable UUID id, @RequestBody RecipeItem recipeItem) {
        RecipeItem existingRecipe = recipeRepository.findById(id);
        if (existingRecipe != null) {
            existingRecipe.setTitle(recipeItem.getTitle());
            existingRecipe.setDescription(recipeItem.getDescription());
            recipeRepository.save(existingRecipe);
        } 
        // TODO: Modify the method to return appropriate HTTP status codes:
        // - If the recipe is successfully updated, return the updated RecipeItem and a status code of 200.
        // - If the recipe with the given ID is not found, return a status code of 404.
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existingRecipe, HttpStatus.OK);
    }
}