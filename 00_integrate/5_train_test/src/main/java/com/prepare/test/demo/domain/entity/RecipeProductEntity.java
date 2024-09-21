package com.prepare.test.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recipe_product")
public class RecipeProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipeEntity;
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
    private Long quantity;
    private String unit;
}

