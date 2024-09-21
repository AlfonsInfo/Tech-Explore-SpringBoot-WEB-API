package task.astrapay.demo.service;

import org.springframework.stereotype.Service;
import task.astrapay.demo.domain.dto.request.ReqInsertProductDto;
import task.astrapay.demo.domain.entity.ProductEntity;
import task.astrapay.demo.domain.entity.ProductTagEntity;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductTagMapperService {

    List<ProductTagEntity> mapIntoListProductTagEntityList(List<String> arrayTag , ProductEntity productEntity){
        List<ProductTagEntity> productTagEntities = new LinkedList<>();
        return productTagEntities;
    }
}
