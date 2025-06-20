package com.codesignal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesignal.models.Recipe;

@RestController
public class RecipeController {

    // TODO: Change the URL from "/recipe/sandwich" to "/recipe/american-sandwich"
    // TODO: Refactor the method to return a Recipe object instead of a String
    //       Ensure the Recipe object contains the same instructions: "Layer ham and cheese between two slices of bread, add mayo and mustard"
    @GetMapping("/recipe/american-sandwich")
    public Recipe americanSandwichRecipe() {
        Recipe recipe = new Recipe();
        String instructions = "Layer ham and cheese between two slices of bread, add mayo and mustard";
        recipe.setInstructions(instructions);
        return recipe;
    }
}