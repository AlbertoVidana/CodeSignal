package com.codesignal.controllers;

import com.codesignal.models.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get all recipes without query parameter")
    public void getAllRecipes() throws Exception {
        mockMvc.perform(get("/recipes"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    @DisplayName("Get vegan recipes")
    public void getVeganRecipes() throws Exception {
        mockMvc.perform(get("/recipes").param("type", "VEGAN"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].type").value("VEGAN"));
    }

    @Test
    @DisplayName("Get vegetarian recipes")
    public void getVegetarianRecipes() throws Exception {
        mockMvc.perform(get("/recipes").param("type", "VEGETARIAN"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].type").value("VEGETARIAN"));
    }

    @Test
    @DisplayName("Get non-vegetarian recipes")
    public void getNonVegetarianRecipes() throws Exception {
        mockMvc.perform(get("/recipes").param("type", "NON_VEGETARIAN"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].type").value("NON_VEGETARIAN"));
    }
}