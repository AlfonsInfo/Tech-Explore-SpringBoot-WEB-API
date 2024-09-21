package com.prepare.test.demo.domain.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class ReqInsertProductRecipeDetailDto {
    private String recipeId;
    private Long quantity;
    private String unit;
}
