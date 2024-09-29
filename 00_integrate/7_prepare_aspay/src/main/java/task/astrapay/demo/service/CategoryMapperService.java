package task.astrapay.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.astrapay.demo.domain.entity.CategoryEntity;
import task.astrapay.demo.repository.CategoryRepository;

@Service
public class CategoryMapperService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryMapperService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    CategoryEntity mapIntoCategoryEntity(Integer id){
       return categoryRepository
               .findById(id)
               .orElseThrow();
    }
}
