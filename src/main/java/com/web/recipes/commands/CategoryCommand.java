package com.web.recipes.commands;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author martsiomchyk
 */
@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
}
