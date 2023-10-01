package wf.spring.short_link.utils.validators.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import wf.spring.short_link.utils.validators.constraint.ShortLinkValidator;

import java.lang.annotation.*;



@Constraint(validatedBy = ShortLinkValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ShortLink {

    String message() default "Invalid short link pattern";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}