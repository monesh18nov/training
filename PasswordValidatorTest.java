import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.isValid("Abcdef1@"));
    }

    @Test
    void testShortPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("Ab1@"));
    }

    @Test
    void testNoUppercase() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("abcdef1@"));
    }

    @Test
    void testNoDigit() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("Abcdefg@"));
    }

    @Test
    void testNoSpecialCharacter() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("Abcdef12"));
    }
}