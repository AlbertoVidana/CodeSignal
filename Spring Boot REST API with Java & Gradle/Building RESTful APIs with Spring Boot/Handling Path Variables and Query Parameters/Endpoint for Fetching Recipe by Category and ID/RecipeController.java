/**
 * package com.codesignal.controllers;

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
*/
package com.codesignal.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     public List<Recipe> dietaryRestrictions(@RequestParam String type) {
        List<Recipe> list = recipesRepository.getAllRecipes();
        System.out.print("******************");
        for (Recipe r : list) {
            System.out.print("******************");
            r.getDietaryRestrictions();
            r.getComplexity();
        }
        return list;
    }
}