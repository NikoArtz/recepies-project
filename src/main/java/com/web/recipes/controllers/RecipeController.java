package com.web.recipes.controllers;

import com.web.recipes.commands.RecipeCommand;
import com.web.recipes.exceptions.BadRequestException;
import com.web.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author martsiomchyk
 */
@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }


    @GetMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipe-form";
    }

    @GetMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipe-form";
    }

    @PostMapping("recipe-create")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand recipeCommand) {
        RecipeCommand savedRecipe = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/" + savedRecipe.getId() + "/show";
    }

    @GetMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id) {
        log.debug("Deleting id {}", id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @ExceptionHandler({BadRequestException.class, NumberFormatException.class})
    public ModelAndView handleBadRequestException(Exception exception, HttpServletResponse response) {
        log.error(exception.getClass() + exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bad-request");

        HttpStatus responseStatus;
        String exceptionMessage;
        if (exception instanceof BadRequestException) {
            BadRequestException badRequestException = (BadRequestException) exception;
            responseStatus = badRequestException.getStatus();
            exceptionMessage = badRequestException.getReason();
        } else {
            responseStatus = HttpStatus.BAD_REQUEST;
            exceptionMessage = exception.getMessage();
        }
        response.setStatus(responseStatus.value());
        modelAndView.addObject("status", responseStatus.toString());
        modelAndView.addObject("exception", exceptionMessage);
        return modelAndView;
    }
}