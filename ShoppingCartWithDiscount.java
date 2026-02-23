import java.util.HashMap;
import java.util.Map;

public class ShoppingCartWithDiscount {

    private Map<String, Double> items = new HashMap<>();
    private DiscountService discountService;

    // Constructor Injection
    public ShoppingCartWithDiscount(DiscountService discountService) {
        this.discountService = discountService;
    }

    // Add item
    public void addItem(String item, double price) {
        if (item == null || price < 0) {
            throw new IllegalArgumentException("Invalid item or price");
        }
        items.put(item, price);
    }

    // Remove item
    public void removeItem(String item) {
        if (!items.containsKey(item)) {
            throw new IllegalArgumentException("Item not found in cart");
        }
        items.remove(item);
    }

    // Get final price after discount
    public double getTotalPrice() {
        double total = items.values()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .sum();

        double discount = discountService.getDiscountPercentage();

        return total - (total * discount / 100);
    }
}