package com.web.recipes.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    Category category;

    @BeforeEach
    private void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Long testingId = 4L;
        category.setId(testingId);
        assertEquals(testingId, category.getId());
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}