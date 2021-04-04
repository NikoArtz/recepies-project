package com.web.recipes.services;

import com.web.recipes.commands.IngredientCommand;

/**
 * @author martsiomchyk
 */

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(Long recipeId, Long ingredientId);
}
