import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderServiceTest {

    private OrderService service = new OrderService();

    @Test
    void testCalculateTotal() {
        List<Order> orders = Arrays.asList(
                new Order(1, 100),
                new Order(2, 200),
                new Order(3, 300)
        );

        double total = service.calculateTotal(orders);

        assertEquals(600, total);
    }

    @Test
    void testFilterOrdersAboveThreshold() {
        List<Order> orders = Arrays.asList(
                new Order(1, 100),
                new Order(2, 500),
                new Order(3, 700)
        );

        List<Order> filtered = service.filterOrdersAboveThreshold(orders, 400);

        assertEquals(2, filtered.size());
    }

    @Test
    void testNoOrdersExist() {
        List<Order> orders = Collections.emptyList();

        double total = service.calculateTotal(orders);

        assertEquals(0, total);
    }

    @Test
    void testMultipleOrdersAggregation() {
        List<Order> orders = Arrays.asList(
                new Order(1, 150),
                new Order(2, 250),
                new Order(3, 350)
        );

        assertEquals(750, service.calculateTotal(orders));
    }

    @Test
    void testNegativeOrderThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order(1, -100);
        });
    }
}
