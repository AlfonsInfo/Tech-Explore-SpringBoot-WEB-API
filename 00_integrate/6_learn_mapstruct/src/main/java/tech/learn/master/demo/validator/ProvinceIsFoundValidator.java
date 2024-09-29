package tech.learn.master.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import tech.learn.master.demo.exception.DataNotFoundException;
import tech.learn.master.demo.repository.ProvinceRepository;
import tech.learn.master.demo.validator.constraint.ProvinceIsFound;


@RequiredArgsConstructor
public class ProvinceIsFoundValidator implements ConstraintValidator<ProvinceIsFound, Long> {
    private final ProvinceRepository provinceRepository;

    @SneakyThrows
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(provinceRepository.findById(value).isEmpty()){
            throw new DataNotFoundException("Province not found");
        }
        return true;
    }
}
