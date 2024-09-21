package tech.learn.master.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import tech.learn.master.demo.domain.dto.province.ProvinceUpsertDto;
import tech.learn.master.demo.exception.DuplicateException;
import tech.learn.master.demo.repository.ProvinceRepository;
import tech.learn.master.demo.validator.constraint.ProvinceIsUnique;


@RequiredArgsConstructor
public class ProvinceIsUniqueValidator implements ConstraintValidator<ProvinceIsUnique, ProvinceUpsertDto> {
    private final ProvinceRepository provinceRepository;


    @SneakyThrows
    @Override
    public boolean isValid(ProvinceUpsertDto value, ConstraintValidatorContext context) {
        //if group post validation
        if(value.getProvinceId() != null){
            if(provinceRepository.existsByProvinceNameIgnoreCaseAndIdNot(value.getProvinceName(),value.getProvinceId())){
                throw new DuplicateException("Province name already exists");
            }
            return true;
        }
        //if group put validation

        if(provinceRepository.existsByProvinceNameIgnoreCase(value.getProvinceName())){
            throw new DuplicateException("Province name already exists");
        }
        return true;
    }
}
