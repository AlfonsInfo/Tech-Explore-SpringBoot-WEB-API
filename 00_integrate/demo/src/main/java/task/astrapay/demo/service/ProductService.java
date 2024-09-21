package task.astrapay.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.astrapay.demo.domain.dto.request.ReqInsertProductDto;
import task.astrapay.demo.domain.dto.request.ReqUpdateProductDto;
import task.astrapay.demo.domain.dto.response.ResMessageDto;
import task.astrapay.demo.domain.dto.response.ResProductListDto;
import task.astrapay.demo.domain.entity.CategoryEntity;
import task.astrapay.demo.domain.entity.ProductEntity;
import task.astrapay.demo.domain.entity.ProductTagEntity;
import task.astrapay.demo.repository.ProductRepository;
import task.astrapay.demo.repository.ProductTagRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    //repository
    private final ProductRepository productRepository;
    private final ProductTagRepository productTagRepository;

    //mapper
    private final ProductMapperService productMapperService;
    private final ProductTagMapperService productTagMapperService;
    private final CategoryMapperService categoryMapperService;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductTagRepository productTagRepository, ProductMapperService productMapperService, ProductTagMapperService productTagMapperService, CategoryMapperService categoryMapperService) {
        this.productRepository = productRepository;
        this.productTagRepository = productTagRepository;
        this.productMapperService = productMapperService;
        this.productTagMapperService = productTagMapperService;
        this.categoryMapperService = categoryMapperService;
    }

    @Transactional
    public ResMessageDto<Object> createProduct(ReqInsertProductDto request){
        //mapping
        CategoryEntity categoryEntity = categoryMapperService.mapIntoCategoryEntity(request.getCategoryId());
        ProductEntity productEntity = productMapperService.mapIntoProductEntity(request,categoryEntity);
        List<ProductTagEntity> productTagEntity =  productTagMapperService.mapIntoListProductTagEntityList(request.getArrayTagId(), productEntity);

        //persisting
        productRepository.save(productEntity);
        productTagRepository.saveAll(productTagEntity);

        //build response
        return new ResMessageDto<>();
    }


    @Transactional
    public ResMessageDto<Object> updateProduct(ReqUpdateProductDto request){
        CategoryEntity categoryEntity = categoryMapperService.mapIntoCategoryEntity(request.getCategoryId());
        ProductEntity productEntity = productMapperService.mapIntoProductEntity(request,categoryEntity);

        //persisting
        productRepository.save(productEntity);
        if(!request.getArrayTagId().isEmpty()){
            //truncate
            List<ProductTagEntity> oldProductTagList = productTagRepository.findAllByProductEntity(productEntity);
            productTagRepository.deleteAll(oldProductTagList);
            //save all
            List<ProductTagEntity> productTagEntity =  productTagMapperService.mapIntoListProductTagEntityList(request.getArrayTagId(), productEntity);
            productTagRepository.saveAll(productTagEntity);
        }

        //build response
        return new ResMessageDto<>();
    }

    public ResMessageDto<List<ResProductListDto>> getListProduct(){
        //result
        List<ResProductListDto> listResult = new ArrayList<>();

        //get data
        List<ProductEntity> listProduct = productRepository.findAll();

        //mapping
        listProduct.forEach( product -> {
            ResProductListDto resProductListDto = new ResProductListDto();
            listResult.add(resProductListDto);
        });

        //building response
        return ResMessageDto
                .<List<ResProductListDto>>builder()
                .data(listResult)
                .build();
    }


    @Transactional
    public ResMessageDto<Object> deleteProduct(String id){
        productRepository.deleteById(Integer.valueOf(id));
        return new ResMessageDto<>();
    }
}
