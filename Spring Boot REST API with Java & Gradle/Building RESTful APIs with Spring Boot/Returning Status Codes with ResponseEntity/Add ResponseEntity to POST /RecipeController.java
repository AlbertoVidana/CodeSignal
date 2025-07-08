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
    public List<RecipeItem> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @PostMapping("/recipes")
    // TODO: Update this method to use ResponseEntity for more meaningful responses as per the task instructions.
    public ResponseEntity<RecipeItem> addRecipe(@RequestBody RecipeItem recipeItem) {
        if (recipeItem.getTitle() == null || recipeItem.getTitle().isEmpty() ||
            recipeItem.getDescription() == null || recipeItem.getDescription().isEmpty()) {
            // TODO: Return a 400 Bad Request status code if the recipe data is invalid
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        recipeRepository.save(recipeItem);
        // TODO: Return a 201 Created status code with the newly created RecipeItem in the response body
        return new ResponseEntity<>(recipeItem, HttpStatus.CREATED);
    }
}