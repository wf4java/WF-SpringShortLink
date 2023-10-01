package wf.spring.short_link.utils.validators.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import wf.spring.short_link.properties.AppProperties;
import wf.spring.short_link.utils.EncodeUtils;
import wf.spring.short_link.utils.validators.annotation.ShortLink;

@RequiredArgsConstructor
public class ShortLinkValidator  implements ConstraintValidator<ShortLink, String> {

    private final EncodeUtils encodeUtils;
    private final AppProperties appProperties;

    @Override
    public boolean isValid(String shortLink, ConstraintValidatorContext context) {
        if(shortLink == null) return true;
        if(shortLink.isBlank()) return false;

        if(shortLink.length() > appProperties.getShortLinkMaxLength()) return false;

        return encodeUtils.isValid(shortLink);
    }

}
