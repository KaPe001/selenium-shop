package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.darekTask.BasePage;

import static pages.BasePage.removeCurrency;

public class BasketProductPage extends BasePage {
    public BasketProductPage(WebElement product) {
        PageFactory.initElements(new DefaultElementLocatorFactory(product), this);
    }

    @FindBy(css = ".product-line-grid a")
    WebElement productName;

    @FindBy(css = ".product-line-grid .product-line-grid-right .product-price strong")
    WebElement productTotalPrice;

    public String getProductName(){
        return productName.getText();
    }

    public String getProductTotalPrice(){
        return removeCurrency(productTotalPrice.getText());
    }
}
