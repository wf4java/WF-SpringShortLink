package wf.spring.short_link.utils.validators.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import wf.spring.short_link.utils.validators.constraint.LinkValidator;

import java.lang.annotation.*;

@Constraint(validatedBy = LinkValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Link {

    String message() default "Invalid link";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
