import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Double> items = new HashMap<>();

    // Add item to cart
    public void addItem(String item, double price) {
        if (item == null || price < 0) {
            throw new IllegalArgumentException("Invalid item or price");
        }
        items.put(item, price);
    }

    // Remove item from cart
    public void removeItem(String item) {
        if (!items.containsKey(item)) {
            throw new IllegalArgumentException("Item not found in cart");
        }
        items.remove(item);
    }

    // Get total price
    public double getTotalPrice() {
        double total = 0;
        for (double price : items.values()) {
            total += price;
        }
        return total;
    }
}