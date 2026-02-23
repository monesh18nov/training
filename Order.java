public class Order {

    private int id;
    private double amount;

    public Order(int id, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Order amount cannot be negative");
        }
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}