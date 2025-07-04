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

    @PostMapping("/recipes")
    public ResponseEntity<RecipeItem> addRecipe(@RequestBody RecipeItem recipeItem) {
        recipeRepository.save(recipeItem);
        return new ResponseEntity<>(recipeItem, HttpStatus.CREATED);
    }

    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeItem>> getAllRecipes() {
        return new ResponseEntity<>(recipeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<RecipeItem> getRecipeById(@PathVariable UUID id) {
        RecipeItem recipe = recipeRepository.findById(id);
        if (recipe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<RecipeItem> updateRecipe(@PathVariable UUID id, @RequestBody RecipeItem updatedRecipe) {
        RecipeItem existingRecipe = recipeRepository.findById(id);
        if (existingRecipe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingRecipe.setTitle(updatedRecipe.getTitle());
        existingRecipe.setDescription(updatedRecipe.getDescription());

        return new ResponseEntity<>(existingRecipe, HttpStatus.OK);
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable UUID id) {
        RecipeItem recipe = recipeRepository.findById(id);
        if (recipe == null) {
            return new ResponseEntity<>("Recipe not found!", HttpStatus.NOT_FOUND);
        }

        recipeRepository.delete(id);
        return new ResponseEntity<>("Recipe deleted!", HttpStatus.OK);
    }
}