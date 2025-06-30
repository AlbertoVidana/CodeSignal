package com.codesignal.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codesignal.models.Recipe;
import com.codesignal.repositories.RecipesRepository;

@RestController
public class RecipeController {

    private final RecipesRepository recipesRepository;

    @Autowired
    public RecipeController(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    // TODO: Add a new endpoint "/category/{categoryName}/recipes/{recipeId}". 
    //       The category name is a String and the recipeId is an int.
    //       Use the repository method "getRecipeByCategoryNameAndRecipeId" to return the result.
    //       Return an IllegalArgumentException if the recipe is not found.
    @GetMapping("/category/{categoryName}/recipes/{recipeId}")
    public Recipe getRecipeByCategoryNameAndRecipeId(@PathVariable String categoryName, @PathVariable int recipeId) {
        return recipesRepository.getRecipeByCategoryNameAndRecipeId(categoryName, recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found"));
    }
}