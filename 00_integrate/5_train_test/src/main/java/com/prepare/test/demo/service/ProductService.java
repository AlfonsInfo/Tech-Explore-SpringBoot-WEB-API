package com.prepare.test.demo.service;

import com.prepare.test.demo.domain.dto.common.ResMessageDto;
import com.prepare.test.demo.domain.dto.request.ReqInsertProductDto;

public interface ProductService {

    ResMessageDto<Object> createProduct(ReqInsertProductDto request);
}
