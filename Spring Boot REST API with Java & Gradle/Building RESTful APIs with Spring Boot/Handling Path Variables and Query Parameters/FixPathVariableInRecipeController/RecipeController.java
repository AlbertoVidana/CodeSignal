package com.codesignal.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    //@GetMapping("/recipes/{id}") Original, I fix this problem using pure loginc
    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipeById(@PathVariable Integer recipeId) {
        return recipesRepository.findRecipeById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found"));
    }
}