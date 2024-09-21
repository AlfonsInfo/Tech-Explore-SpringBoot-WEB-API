package com.prepare.test.demo.service.impl;

import com.prepare.test.demo.domain.dto.common.ResMessageDto;
import com.prepare.test.demo.domain.dto.request.ReqInsertProductDto;
import com.prepare.test.demo.domain.entity.ProductEntity;
import com.prepare.test.demo.domain.entity.RecipeEntity;
import com.prepare.test.demo.repository.ProductRepository;
import com.prepare.test.demo.service.ProductMapperService;
import com.prepare.test.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
    //Repository
    private final ProductRepository productRepository;

    //Validation

    //Mapper
    private final ProductMapperService productMapperService;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapperService productMapperService) {
        this.productRepository = productRepository;
        this.productMapperService = productMapperService;
    }


    @Override
    @Transactional
    public ResMessageDto<Object> createProduct(ReqInsertProductDto request) {

        ProductEntity productEntity = productMapperService.mapToProductEntity(request);
        RecipeEntity recipeEntity =



        return null;
    }
}
