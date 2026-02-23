import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    void testStrongPassword() {
        PasswordValidator checker = new PasswordValidator();
        assertTrue(checker.isValid("Xyzabc9#"));
    }

    @Test
    void testTooShortPassword() {
        PasswordValidator checker = new PasswordValidator();
        assertFalse(checker.isValid("Xy9#"));
    }

    @Test
    void testMissingUppercase() {
        PasswordValidator checker = new PasswordValidator();
        assertFalse(checker.isValid("xyzabc9#"));
    }

    @Test
    void testMissingDigit() {
        PasswordValidator checker = new PasswordValidator();
        assertFalse(checker.isValid("Xyzabcd#"));
    }

    @Test
    void testMissingSpecialCharacter() {
        PasswordValidator checker = new PasswordValidator();
        assertFalse(checker.isValid("Xyzabc12"));
    }
}
