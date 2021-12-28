package configuration.basket;

import java.math.BigDecimal;

public class Order extends Product {
    private Product product;
    private int quantity;
    private static BigDecimal totalCost;

    public Order(Product product, int quantity) {
        super(product.getName(), product.getPrice());
        this.product = product;
        this.quantity = quantity;
        totalCost = getPrice() != null ? getPrice().multiply(BigDecimal.valueOf(quantity)) : null;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public static BigDecimal getTotalCost() {
        return totalCost;
    }
}
