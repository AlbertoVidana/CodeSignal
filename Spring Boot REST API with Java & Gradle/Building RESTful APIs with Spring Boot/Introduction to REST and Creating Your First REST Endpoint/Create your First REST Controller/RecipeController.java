package com.codesignal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @GetMapping("/recipe/sandwich")
    public String sandwichRecipe() {
        return "Layer ham and cheese between two slices of bread, add mayo and mustard";
    }
}