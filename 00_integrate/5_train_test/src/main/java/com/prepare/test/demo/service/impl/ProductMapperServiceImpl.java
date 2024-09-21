package com.prepare.test.demo.service.impl;

import com.prepare.test.demo.domain.dto.request.ReqInsertProductDto;
import com.prepare.test.demo.domain.entity.ProductEntity;
import com.prepare.test.demo.service.ProductMapperService;

public class ProductMapperServiceImpl implements ProductMapperService {
    @Override
    public ProductEntity mapToProductEntity(ReqInsertProductDto request) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(request.getName());
        productEntity.setDescription(request.getDescription());
        productEntity.setPrice(request.getPrice());
        return productEntity;
    }
}
