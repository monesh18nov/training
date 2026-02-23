import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ProductServiceTest {

    // 1️⃣ Verify 10% discount applied correctly
    @Test
    void testTenPercentDiscount() {

        Function<Product, Double> tenPercentDiscount =
                product -> product.getPrice() * 0.9;

        ProductService service = new ProductService(tenPercentDiscount);

        Product product = new Product("Laptop", 1000);

        assertEquals(900, service.applyDiscount(product));
    }

    // 2️⃣ Ensure 0% discount returns original price
    @Test
    void testZeroPercentDiscount() {

        Function<Product, Double> zeroDiscount =
                product -> product.getPrice();

        ProductService service = new ProductService(zeroDiscount);

        Product product = new Product("Mobile", 500);

        assertEquals(500, service.applyDiscount(product));
    }

    // 3️⃣ Verify negative price throws exception
    @Test
    void testNegativePriceThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Product("Tablet", -100);
        });
    }

    // 4️⃣ Multiple products discounted using Stream
    @Test
    void testMultipleProductsDiscounted() {

        Function<Product, Double> tenPercentDiscount =
                product -> product.getPrice() * 0.9;

        ProductService service = new ProductService(tenPercentDiscount);

        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000),
                new Product("Mobile", 500)
        );

        List<Double> discountedPrices = service.applyDiscountToAll(products);

        assertEquals(900, discountedPrices.get(0));
        assertEquals(450, discountedPrices.get(1));
    }

    // 5️⃣ Ensure discount function can be swapped dynamically
    @Test
    void testDynamicDiscountSwap() {

        Function<Product, Double> tenPercent =
                product -> product.getPrice() * 0.9;

        Function<Product, Double> fiftyPercent =
                product -> product.getPrice() * 0.5;

        ProductService service = new ProductService(tenPercent);

        Product product = new Product("Laptop", 1000);

        assertEquals(900, service.applyDiscount(product));

        // Change discount dynamically
        service.setDiscountFunction(fiftyPercent);

        assertEquals(500, service.applyDiscount(product));
    }
}