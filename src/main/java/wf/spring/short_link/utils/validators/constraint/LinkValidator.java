package wf.spring.short_link.utils.validators.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import wf.spring.short_link.utils.validators.annotation.Link;


public class LinkValidator implements ConstraintValidator<Link, String> {

    private static final String LINK_PATTERN = "(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\." +
            "\\S{2,}|[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\." +
            "\\S{2,}|www\\.[a-zA-Z0-9]+\\.\\S{2,})";


    @Override
    public boolean isValid(String link, ConstraintValidatorContext context) {
        if(link == null) return true;
        if(link.isBlank()) return false;

        return link.matches(LINK_PATTERN);
    }

}