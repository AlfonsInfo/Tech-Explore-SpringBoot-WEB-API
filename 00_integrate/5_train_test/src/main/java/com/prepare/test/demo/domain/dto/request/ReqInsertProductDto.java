package com.prepare.test.demo.domain.dto.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class ReqInsertProductDto {
    private String name;
    private String description;
    private Long price;
    private List<ReqInsertProductRecipeDetailDto> recipeDetail = new LinkedList<>();
}
