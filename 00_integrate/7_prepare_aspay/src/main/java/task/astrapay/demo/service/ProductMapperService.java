package task.astrapay.demo.service;

import org.springframework.stereotype.Service;
import task.astrapay.demo.domain.dto.request.ReqInsertProductDto;
import task.astrapay.demo.domain.dto.request.ReqUpdateProductDto;
import task.astrapay.demo.domain.entity.CategoryEntity;
import task.astrapay.demo.domain.entity.ProductEntity;
import task.astrapay.demo.repository.ProductRepository;

@Service
public class ProductMapperService {

    //repository
    private ProductRepository productRepository;

    ProductEntity mapIntoProductEntity(ReqInsertProductDto request, CategoryEntity categoryEntity){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setTitle(request.getTitle());
        productEntity.setDescription(request.getDescription());
        productEntity.setRating(request.getRating());
        productEntity.setStock(request.getStock());
        productEntity.setCategoryEntity(categoryEntity);

        return productEntity;
    }

    ProductEntity mapIntoProductEntity(ReqUpdateProductDto request, CategoryEntity categoryEntity){
        //searching instance for updated
        ProductEntity productEntity = productRepository.findById(request.getId()).orElseThrow();
        productEntity.setTitle(request.getTitle());
        productEntity.setDescription(request.getDescription());
        productEntity.setRating(request.getRating());
        productEntity.setStock(request.getStock());
        productEntity.setCategoryEntity(categoryEntity);
        return productEntity;
    }
}
