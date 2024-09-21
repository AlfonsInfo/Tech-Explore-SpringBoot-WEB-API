package com.prepare.test.demo.service;

import com.prepare.test.demo.domain.dto.request.ReqInsertProductDto;
import com.prepare.test.demo.domain.entity.ProductEntity;

public interface RecipeMapperService {

    ProductEntity mapToProductEntity(ReqInsertProductDto request);
}
