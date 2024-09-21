package com.prepare.test.demo.service;

import com.prepare.test.demo.domain.dto.common.ResMessageDto;
import com.prepare.test.demo.domain.dto.request.ReqInsertProductDto;
import com.prepare.test.demo.domain.entity.ProductEntity;

public interface ProductMapperService {

    ProductEntity mapToProductEntity(ReqInsertProductDto request);
}
