package wf.spring.short_link.utils.validators.constraint;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class LinkValidatorTest {

    private LinkValidator linkValidator;

    @Mock
    private ConstraintValidatorContext context;

    @BeforeEach
    void setUp() {
        linkValidator = new LinkValidator();
    }

    @Test
    void testIsValidWhenLinkIsValidAndContextIsNullThenReturnTrue() {
        String validLink = "https://www.google.com";
        assertTrue(linkValidator.isValid(validLink, null));
    }

    @Test
    void testIsValidWhenLinkIsInvalidAndContextIsNullThenReturnFalse() {
        String invalidLink = "invalidLink";
        assertFalse(linkValidator.isValid(invalidLink, null));
    }

    @Test
    void testIsValidWhenLinkIsNullAndContextIsNullThenReturnTrue() {
        assertTrue(linkValidator.isValid(null, null));
    }

    @Test
    void testIsValidWhenLinkIsBlankAndContextIsNullThenReturnFalse() {
        String blankLink = "";
        assertFalse(linkValidator.isValid(blankLink, null));
    }


}