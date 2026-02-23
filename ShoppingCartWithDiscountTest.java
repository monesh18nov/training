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

    @Test
    void testTenPercentDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(10.0);

        cart.addItem("Notebook", 800.0);

        double finalPrice = cart.getTotalPrice();

        assertEquals(720.0, finalPrice);
    }

    @Test
    void testZeroPercentDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(0.0);

        cart.addItem("Eraser", 50.0);

        double finalPrice = cart.getTotalPrice();

        assertEquals(50.0, finalPrice);
    }

    @Test
    void testFiftyPercentDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(50.0);

        cart.addItem("Tablet", 3000.0);

        double finalPrice = cart.getTotalPrice();

        assertEquals(1500.0, finalPrice);
    }

    @Test
    void testDiscountMethodCalledOnce() {
        when(discountService.getDiscountPercentage()).thenReturn(15.0);

        cart.addItem("Notebook", 1000.0);

        cart.getTotalPrice();

        verify(discountService, times(1)).getDiscountPercentage();
    }

    @Test
    void testMultipleItemsWithDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(25.0);

        cart.addItem("Monitor", 2000.0);
        cart.addItem("Keyboard", 1000.0);

        double finalPrice = cart.getTotalPrice();

        assertEquals(2250.0, finalPrice);
    }
}
