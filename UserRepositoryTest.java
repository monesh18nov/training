import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class CustomerStoreTest {

    private CustomerStore store = new CustomerStore();

    @Test
    void testExistingCustomerId() {

        Optional<Customer> result = store.fetchById(10);

        assertTrue(result.isPresent());
        assertEquals("Arjun", result.get().getUsername());
    }

    @Test
    void testNonExistingCustomerId() {

        Optional<Customer> result = store.fetchById(999);

        assertFalse(result.isPresent());
    }

    @Test
    void testGetOnEmptyResultThrowsException() {

        Optional<Customer> result = store.fetchById(999);

        assertThrows(NoSuchElementException.class, result::get);
    }

    @Test
    void testOrElseReturnsFallbackCustomer() {

        Customer fallback = new Customer(0, "Guest");

        Customer result = store.fetchById(999)
                               .orElse(fallback);

        assertEquals("Guest", result.getUsername());
    }

    @Test
    void testIsPresentForExistingAndNonExisting() {

        Optional<Customer> present = store.fetchById(10);
        Optional<Customer> absent = store.fetchById(888);

        assertTrue(present.isPresent());
        assertFalse(absent.isPresent());
    }
}
