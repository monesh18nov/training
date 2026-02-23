import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UserRepositoryTest {

    private UserRepository repository = new UserRepository();

    // 1️⃣ Valid user ID returns non-empty Optional
    @Test
    void testValidUserId() {

        Optional<User> user = repository.findById(1);

        assertTrue(user.isPresent());
        assertEquals("Gaurav", user.get().getName());
    }

    // 2️⃣ Invalid user ID returns Optional.empty()
    @Test
    void testInvalidUserId() {

        Optional<User> user = repository.findById(100);

        assertFalse(user.isPresent());
    }

    // 3️⃣ get() on empty Optional throws exception
    @Test
    void testGetOnEmptyOptionalThrowsException() {

        Optional<User> user = repository.findById(100);

        assertThrows(NoSuchElementException.class, () -> {
            user.get();
        });
    }

    // 4️⃣ orElse() returns default user when ID not found
    @Test
    void testOrElseReturnsDefaultUser() {

        User defaultUser = new User(0, "Default");

        User user = repository.findById(100)
                              .orElse(defaultUser);

        assertEquals("Default", user.getName());
    }

    // 5️⃣ isPresent() works correctly
    @Test
    void testIsPresentForValidAndInvalid() {

        Optional<User> validUser = repository.findById(1);
        Optional<User> invalidUser = repository.findById(200);

        assertTrue(validUser.isPresent());
        assertFalse(invalidUser.isPresent());
    }
}