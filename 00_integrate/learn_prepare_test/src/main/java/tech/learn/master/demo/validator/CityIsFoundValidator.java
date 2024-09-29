package tech.learn.master.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import tech.learn.master.demo.exception.DataNotFoundException;
import tech.learn.master.demo.repository.CityRepository;
import tech.learn.master.demo.validator.constraint.CityIsFound;


@RequiredArgsConstructor
public class CityIsFoundValidator implements ConstraintValidator<CityIsFound, Long> {
    private final CityRepository cityRepository;

    @SneakyThrows
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(cityRepository.findById(value).isEmpty()){
            throw new DataNotFoundException("City not found");
        }
        return true;
    }
}
