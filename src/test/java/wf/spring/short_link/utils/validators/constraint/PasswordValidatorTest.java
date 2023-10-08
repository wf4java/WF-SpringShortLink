package wf.spring.short_link.utils.validators.constraint;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;
    private ConstraintValidatorContext context;

    @BeforeEach
    public void setUp() {
        passwordValidator = new PasswordValidator();
        context = mock(ConstraintValidatorContext.class);
    }

    @Test
    public void testIsValidWhenValidPasswordThenReturnTrue() {
        String validPassword = "ValidPassword123#";
        boolean isValid = passwordValidator.isValid(validPassword, context);
        assertThat(isValid).isTrue();
    }

    @Test
    public void testIsValidWhenNullPasswordThenReturnTrue() {
        String nullPassword = null;
        boolean isValid = passwordValidator.isValid(nullPassword, context);
        assertThat(isValid).isTrue();
    }

    @Test
    public void testIsValidWhenEmptyPasswordThenReturnFalse() {
        String emptyPassword = "";
        boolean isValid = passwordValidator.isValid(emptyPassword, context);
        assertThat(isValid).isFalse();
    }

    @Test
    public void testIsValidWhenPasswordWithLessThan8CharsThenReturnFalse() {
        String shortPassword = "Short1#";
        boolean isValid = passwordValidator.isValid(shortPassword, context);
        assertThat(isValid).isFalse();
    }

    @Test
    public void testIsValidWhenPasswordWithMoreThan64CharsThenReturnFalse() {
        String longPassword = "ThisIsAVeryLongPasswordThatHasMoreThan64CharactersIncludingNumbers1234567890AndSpecialCharacters#";
        boolean isValid = passwordValidator.isValid(longPassword, context);
        assertThat(isValid).isFalse();
    }

    @Test
    public void testIsValidWhenNullContextThenReturnTrue() {
        String validPassword = "ValidPassword123#";
        boolean isValid = passwordValidator.isValid(validPassword, null);
        assertThat(isValid).isTrue();
    }
}