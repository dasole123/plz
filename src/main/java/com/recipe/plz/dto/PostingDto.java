package com.recipe.plz.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostingDto {
    private String title;
    private String recipe_context;
    private String image;
}
