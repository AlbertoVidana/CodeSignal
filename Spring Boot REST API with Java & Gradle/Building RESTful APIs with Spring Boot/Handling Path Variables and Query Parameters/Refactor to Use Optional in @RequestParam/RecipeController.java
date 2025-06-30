package com.codesignal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/recipes")
    public List<Recipe> getRecipes(@RequestParam(name = "type", required = false) Recipe.Type type) {
        if (type != null) {
            return recipesRepository.getRecipesByType(type);
        } else {
            return recipesRepository.getAllRecipes();
        }
    }
}