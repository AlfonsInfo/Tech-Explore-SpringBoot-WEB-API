package com.prepare.test.demo.controller;

import com.prepare.test.demo.domain.dto.common.ResMessageDto;
import com.prepare.test.demo.domain.dto.request.ReqInsertProductDto;
import com.prepare.test.demo.domain.dto.request.ReqInsertProductRecipeDetailDto;
import com.prepare.test.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResMessageDto<Object> create(ReqInsertProductDto request){
        return productService.createProduct(request);
    }
}
