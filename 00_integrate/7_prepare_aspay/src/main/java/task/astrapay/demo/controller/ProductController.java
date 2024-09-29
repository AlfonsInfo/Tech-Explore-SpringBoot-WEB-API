package task.astrapay.demo.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.astrapay.demo.domain.dto.request.ReqInsertProductDto;
import task.astrapay.demo.domain.dto.request.ReqUpdateProductDto;
import task.astrapay.demo.domain.dto.response.ResMessageDto;
import task.astrapay.demo.domain.dto.response.ResProductListDto;
import task.astrapay.demo.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("rest/v1/product")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    ResMessageDto<Object> createProduct(@Valid ReqInsertProductDto request){
        return productService.createProduct(request);
    }

    @PutMapping
    ResMessageDto<Object> updateProduct(@Valid ReqUpdateProductDto request){
        return productService.updateProduct(request);
    }

    @GetMapping
    ResMessageDto<List<ResProductListDto>> getListProduct(){
        return productService.getListProduct();
    }

    @DeleteMapping
    ResMessageDto<Object> deleteProduct(@RequestParam String id){
        return productService.deleteProduct(id);
    }






}
