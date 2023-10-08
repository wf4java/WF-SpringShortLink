package wf.spring.short_link.utils.validators.constraint;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wf.spring.short_link.properties.AppProperties;
import wf.spring.short_link.utils.EncodeUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ShortLinkValidatorTest {

    private ShortLinkValidator shortLinkValidator;

    @Mock
    private EncodeUtils encodeUtils;

    @Mock
    private AppProperties appProperties;

    @Mock
    private ConstraintValidatorContext context;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        shortLinkValidator = new ShortLinkValidator(encodeUtils, appProperties);
    }

    @Test
    public void testIsValidWhenShortLinkIsNullThenReturnTrue() {
        assertTrue(shortLinkValidator.isValid(null, context));
    }

    @Test
    public void testIsValidWhenShortLinkIsEmptyThenReturnFalse() {
        assertFalse(shortLinkValidator.isValid("", context));
    }

    @Test
    public void testIsValidWhenShortLinkIsLongerThanMaxLengthThenReturnFalse() {
        when(appProperties.getShortLinkMaxLength()).thenReturn(5);
        assertFalse(shortLinkValidator.isValid("abcdef", context));
    }

    @Test
    public void testIsValidWhenShortLinkIsValidThenReturnTrue() {
        when(appProperties.getShortLinkMaxLength()).thenReturn(5);
        when(encodeUtils.isValid("abcde")).thenReturn(true);
        assertTrue(shortLinkValidator.isValid("abcde", context));
    }
}