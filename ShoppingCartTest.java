import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    // 1. Verify that adding items increases total price correctly
    @Test
    void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 500.0);
        cart.addItem("Pen", 20.0);

        assertEquals(520.0, cart.getTotalPrice());
    }

    // 2. Ensure removing an item decreases total price correctly
    @Test
    void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 500.0);
        cart.addItem("Pen", 20.0);

        cart.removeItem("Pen");

        assertEquals(500.0, cart.getTotalPrice());
    }

    // 3. Check that removing a non-existent item throws an exception
    @Test
    void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 500.0);

        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("Pen");
        });
    }

    // 4. Verify that cart handles multiple items correctly
    @Test
    void testMultipleItems() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 50000.0);
        cart.addItem("Mouse", 800.0);
        cart.addItem("Keyboard", 1500.0);

        assertEquals(52300.0, cart.getTotalPrice());
    }

    // 5. Ensure empty cart returns total price = 0
    @Test
    void testEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        assertEquals(0.0, cart.getTotalPrice());
    }
}