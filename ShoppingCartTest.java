import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Notebook", 450.0);
        cart.addItem("Pencil", 30.0);

        assertEquals(480.0, cart.getTotalPrice());
    }

    @Test
    void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Notebook", 450.0);
        cart.addItem("Pencil", 30.0);

        cart.removeItem("Pencil");

        assertEquals(450.0, cart.getTotalPrice());
    }

    @Test
    void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Notebook", 450.0);

        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("Marker");
        });
    }

    @Test
    void testMultipleItems() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Tablet", 30000.0);
        cart.addItem("Charger", 1200.0);
        cart.addItem("Cover", 900.0);

        assertEquals(32100.0, cart.getTotalPrice());
    }

    @Test
    void testEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        assertEquals(0.0, cart.getTotalPrice());
    }
}
