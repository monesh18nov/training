import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductService {

    private Function<Product, Double> discountFunction;

    // Constructor Injection (Dynamic Lambda)
    public ProductService(Function<Product, Double> discountFunction) {
        this.discountFunction = discountFunction;
    }

    // Apply discount to single product
    public double applyDiscount(Product product) {
        return discountFunction.apply(product);
    }

    // Apply discount to multiple products using Stream
    public List<Double> applyDiscountToAll(List<Product> products) {
        return products.stream()
                .map(discountFunction)
                .collect(Collectors.toList());
    }

    // Change discount dynamically
    public void setDiscountFunction(Function<Product, Double> discountFunction) {
        this.discountFunction = discountFunction;
    }
}