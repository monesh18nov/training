import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ProductServiceTest {

    @Test
    void testTenPercentDiscount() {

        Function<Product, Double> discountTen =
                item -> item.getPrice() * 0.9;

        ProductService service = new ProductService(discountTen);

        Product item = new Product("Monitor", 1200);

        assertEquals(1080, service.applyDiscount(item));
    }

    @Test
    void testZeroPercentDiscount() {

        Function<Product, Double> noDiscount =
                item -> item.getPrice();

        ProductService service = new ProductService(noDiscount);

        Product item = new Product("Headset", 700);

        assertEquals(700, service.applyDiscount(item));
    }

    @Test
    void testNegativePriceThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Product("Keyboard", -200);
        });
    }

    @Test
    void testMultipleProductsDiscounted() {

        Function<Product, Double> discountTen =
                item -> item.getPrice() * 0.9;

        ProductService service = new ProductService(discountTen);

        List<Product> items = Arrays.asList(
                new Product("Monitor", 1200),
                new Product("Mouse", 400)
        );

        List<Double> prices = service.applyDiscountToAll(items);

        assertEquals(1080, prices.get(0));
        assertEquals(360, prices.get(1));
    }

    @Test
    void testDynamicDiscountSwap() {

        Function<Product, Double> discountTen =
                item -> item.getPrice() * 0.9;

        Function<Product, Double> discountHalf =
                item -> item.getPrice() * 0.5;

        ProductService service = new ProductService(discountTen);

        Product item = new Product("Monitor", 1200);

        assertEquals(1080, service.applyDiscount(item));

        service.setDiscountFunction(discountHalf);

        assertEquals(600, service.applyDiscount(item));
    }
}
