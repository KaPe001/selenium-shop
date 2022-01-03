package configuration.basket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BasketClass {
    private Map<Product, Integer> basketProducts = new HashMap<>();

    public BasketClass(Map<Product, Integer> basketProducts) {
        this.basketProducts = basketProducts;
    }

    public BasketClass() {
    }

    public Map<Product, Integer> getBasketProducts() {
        return basketProducts;
    }

    public void setProductsList(Map<Product, Integer> basketProducts) {
        this.basketProducts = basketProducts;
    }

    public void addProductToCart(Product product, int quantity) {
        basketProducts.merge(product, quantity, Integer::sum);
    }

    public void increaseQuantityByExpectedQuantity(Product product, int quantity, int expectedQuantity){
        basketProducts.computeIfPresent(product,(k, v) -> quantity + expectedQuantity);
    }

    public void increaseQuantityByOne(Product product, int quantity){
        basketProducts.computeIfPresent(product,(k, v) -> quantity + 1);
    }

    public void decreaseQuantityByOne(Product product, int quantity){
        basketProducts.computeIfPresent(product,(k, v) -> quantity - 1);
    }

    public void printCart() {
        System.out.println("\nYour cart contains:");
        for (Map.Entry<Product, Integer> productEntry : basketProducts.entrySet()) {
            System.out.println("* Product name: " + productEntry.getKey().getName() + "\nPrice for the single product is: " + "$"
                    + productEntry.getKey().getPrice() + " - Quantity: " + productEntry.getValue());
        }
        System.out.println("The sum of all products in a cart is: $" + (getSumOfAllProducts()));
    }

    public BigDecimal getSumOfAllProducts() {
        BigDecimal sum = new BigDecimal("0.00");

        for (Map.Entry<Product, Integer> productEntry : basketProducts.entrySet()) {
            BigDecimal productTotalPrice;
            productTotalPrice = productEntry.getKey().getPrice().multiply(BigDecimal.valueOf(productEntry.getValue()));
            sum = sum.add(productTotalPrice);
        }
        return sum;
    }
}
