import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartWithDiscountTest {

    @Mock
    private DiscountService discountService;

    @InjectMocks
    private ShoppingCartWithDiscount cart;

    // 1️⃣ Mock 10% discount
    @Test
    void testTenPercentDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(10.0);

        cart.addItem("Book", 1000.0);

        double finalPrice = cart.getTotalPrice();

        assertEquals(900.0, finalPrice);
    }

    // 2️⃣ Mock 0% discount
    @Test
    void testZeroPercentDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(0.0);

        cart.addItem("Pen", 100.0);

        double finalPrice = cart.getTotalPrice();

        assertEquals(100.0, finalPrice);
    }

    // 3️⃣ Mock 50% discount
    @Test
    void testFiftyPercentDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(50.0);

        cart.addItem("Laptop", 2000.0);

        double finalPrice = cart.getTotalPrice();

        assertEquals(1000.0, finalPrice);
    }

    // 4️⃣ Verify getDiscountPercentage() called exactly once
    @Test
    void testDiscountMethodCalledOnce() {
        when(discountService.getDiscountPercentage()).thenReturn(10.0);

        cart.addItem("Book", 1000.0);

        cart.getTotalPrice();

        verify(discountService, times(1)).getDiscountPercentage();
    }

    // 5️⃣ Multiple items with discount
    @Test
    void testMultipleItemsWithDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(20.0);

        cart.addItem("Laptop", 1000.0);
        cart.addItem("Mouse", 500.0);

        double finalPrice = cart.getTotalPrice();

        // Total = 1500, 20% discount = 300
        assertEquals(1200.0, finalPrice);
    }
}