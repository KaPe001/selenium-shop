package configuration.basket;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Product) {
            Product product = (Product) obj;
            return this.name.equals(product.getName()) && Objects.equals(this.price, product.getPrice());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * price.hashCode();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
