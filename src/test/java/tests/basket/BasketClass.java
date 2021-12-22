//package tests.basket;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
//public class BasketClass {
//    private Map<Product, Integer> productsList = new HashMap<>();
//    private Product quantity;
//    private BigDecimal totalCost;
//
//    public BasketClass(Map<Product, Integer> productsList) {
//        this.productsList = this.productsList;
//    }
//
//    public BasketClass() {
//    }
//
//    public Map<Product, Integer> getProductsList() {
//        return productsList;
//    }
//
//    public void setProductsList(Map<Product, Integer> productsList) {
//        this.productsList = productsList;
//    }
//
//    public void addProductToCart(Product product, int quantity) {
//        productsList.merge(product, quantity, Integer::sum);
//    }
//
//    public Product getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Product quantity) {
//        this.quantity = quantity;
//    }
//
//    public BigDecimal getTotalCost() {
//        return totalCost;
//    }
//
//    public void setTotalCost(BigDecimal totalCost) {
//        this.totalCost = totalCost;
//    }
//
//    public void printCart() {
//        System.out.println("\nYour cart contains:");
//        for (Map.Entry<Product, Integer> productEntry : productsList.entrySet()) {
//            System.out.println("* Product name: " + productEntry.getKey().getName() + "\nPrice for the single product is: " + "$"
//                    + productEntry.getKey().getPrice() + " - Quantity: " + productEntry.getValue());
//        }
//        System.out.println("The sum of all products in a cart is: $" + (getSumOfAllProducts()));
//    }
//
//    public BigDecimal getSumOfAllProducts() {
//        BigDecimal sum = new BigDecimal("0.00");
//
//        for (Map.Entry<Product, Integer> productEntry : productsList.entrySet()) {
//            BigDecimal productTotalPrice;
//            productTotalPrice = productEntry.getKey().getPrice().multiply(BigDecimal.valueOf(productEntry.getValue()));
//            sum = sum.add(productTotalPrice);
//        }
//        return sum;
//    }
//}
