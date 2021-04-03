package com.web.recipes.services;

import com.web.recipes.commands.IngredientCommand;

/**
 * @author martsiomchyk
 */

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
