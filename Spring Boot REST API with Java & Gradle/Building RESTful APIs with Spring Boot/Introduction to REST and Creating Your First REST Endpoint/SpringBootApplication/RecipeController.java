package com.codesignal.controllers;

import com.codesignal.models.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @GetMapping("/recipe/american-sandwich")
    public Recipe americanSandwichRecipe() {
        Recipe recipe = new Recipe();
        recipe.setInstructions("Layer ham and cheese between two slices of bread, add mayo and mustard");
        return recipe;
    }

    // TODO: Add a new endpoint with the URL /recipe/salad
    // TODO: Make sure it returns a Recipe object containing the instructions:
    // "Chop lettuce, tomatoes, cucumbers, and onions. Mix with olive oil and vinegar."
    @GetMapping("/recipe/salad")
    public Recipe salad() {
        Recipe recipe = new Recipe();
        String instructions = "Chop lettuce, tomatoes, cucumbers, and onions. Mix with olive oil and vinegar.";
        recipe.setInstructions(instructions);
        return recipe;
    }
}