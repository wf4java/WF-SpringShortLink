package wf.spring.short_link.utils.validators.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import wf.spring.short_link.utils.validators.annotation.LongId;

@RequiredArgsConstructor
public class LongIdValidator implements ConstraintValidator<LongId, Long> {

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        if(id == null) return true;
        return id > 0;
    }

}
