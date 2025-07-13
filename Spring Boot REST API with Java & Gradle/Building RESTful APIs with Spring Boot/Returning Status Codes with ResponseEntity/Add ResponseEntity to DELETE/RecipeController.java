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
        RecipeItem savedRecipe = recipeRepository.save(recipeItem);
        return ResponseEntity.ok(savedRecipe);
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<RecipeItem> updateRecipe(@PathVariable UUID id, @RequestBody RecipeItem recipeItem) {
        RecipeItem existingRecipe = recipeRepository.findById(id);
        if (existingRecipe != null) {
            existingRecipe.setTitle(recipeItem.getTitle());
            existingRecipe.setDescription(recipeItem.getDescription());
            recipeRepository.save(existingRecipe);
            return ResponseEntity.ok(existingRecipe);
        }
        return ResponseEntity.notFound().build();
    }
  
    // TODO: Modify this method to use ResponseEntity to return meaningful HTTP status codes.
    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<UUID> deleteRecipe(@PathVariable UUID id) {
        RecipeItem existingRecipe = recipeRepository.findById(id);
        if (existingRecipe != null) {
            recipeRepository.delete(id);
            return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }
}