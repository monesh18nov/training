import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    // Calculate total price of all orders
    public double calculateTotal(List<Order> orders) {
        return orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();
    }

    // Filter orders above threshold
    public List<Order> filterOrdersAboveThreshold(List<Order> orders, double threshold) {
        return orders.stream()
                .filter(order -> order.getAmount() > threshold)
                .collect(Collectors.toList());
    }
}