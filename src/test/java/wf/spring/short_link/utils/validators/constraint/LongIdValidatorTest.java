package wf.spring.short_link.utils.validators.constraint;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongIdValidatorTest {

    private LongIdValidator longIdValidator;

    @Mock
    private ConstraintValidatorContext context;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        longIdValidator = new LongIdValidator();
    }

    @Test
    public void testIsValidWhenIdIsValidThenReturnTrue() {
        Long validId = 1L;
        boolean isValid = longIdValidator.isValid(validId, context);
        assertTrue(isValid, "Expected isValid() to return true for valid id, but it didn't");
    }

    @Test
    public void testIsValidWhenIdIsInvalidThenReturnFalse() {
        Long invalidId = -1L;
        boolean isValid = longIdValidator.isValid(invalidId, context);
        assertFalse(isValid, "Expected isValid() to return false for invalid id, but it didn't");
    }

    @Test
    public void testIsValidWhenIdIsNullThenReturnTrue() {
        Long nullId = null;
        boolean isValid = longIdValidator.isValid(nullId, context);
        assertTrue(isValid, "Expected isValid() to return true for null id, but it didn't");
    }
}