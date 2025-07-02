package com.codesignal.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesignal.repositories.RecipesRepository;
import com.codesignal.models.Recipe;

@RestController
public class RecipeController {

    private final RecipesRepository recipesRepository;

    @Autowired
    public RecipeController(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    // TODO: Add a new endpoint "/recipes" that accepts optional query parameters "dietaryRestrictions" and "complexity". 
    // Use the repository method "getAllRecipes" to get the base list of recipes and filter based on provided query parameters.
    @GetMapping("/recipes")
     public List<Recipe> dietaryRestrictions(@RequestParam (required = false) String type) {
        if (type != null) {
            return recipesRepository.getAllRecipes().stream()
                    .filter(recipe -> recipe.getComplexity() == type)
                    .filter(recipe -> recipe.getDietaryRestrictions() == Arrays.asList(type))
                    .collect(Collectors.toList());
        } else {
            return recipesRepository.getAllRecipes();
        }
    }
}