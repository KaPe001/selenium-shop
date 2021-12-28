package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class BasketProductPage {
    public BasketProductPage(WebElement product) {
        PageFactory.initElements(new DefaultElementLocatorFactory(product), this);
    }

    @FindBy(css = ".product-line-grid a")
    WebElement productName;

    @FindBy(css = ".product-line-grid .product-line-info .price")
    WebElement productPrice;

    @FindBy(css = ".product-line-grid .product-line-grid-right input")
    WebElement productQuantity;

    @FindBy(css = ".product-line-grid .product-line-grid-right .product-price strong")
    WebElement productTotalPrice;

    public String getProductName(){
        return productName.getText();
    }

    public String getProductPrice(){
        return productPrice.getText();
    }

    public String getProductQuantity(){
        return productQuantity.getAttribute("value");
    }

    public String getProductTotalPrice(){
        return productTotalPrice.getText();
    }
}
