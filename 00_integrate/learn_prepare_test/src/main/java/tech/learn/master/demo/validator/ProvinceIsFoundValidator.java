package tech.learn.master.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import tech.learn.master.demo.exception.DuplicateException;
import tech.learn.master.demo.repository.ProvinceRepository;
import tech.learn.master.demo.validator.constraint.ProvinceIsFound;
import tech.learn.master.demo.validator.constraint.ProvinceIsUnique;


@RequiredArgsConstructor
public class ProvinceIsFoundValidator implements ConstraintValidator<ProvinceIsFound, Long> {
    private final ProvinceRepository provinceRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return provinceRepository.findById(value).isPresent();
    }
}
