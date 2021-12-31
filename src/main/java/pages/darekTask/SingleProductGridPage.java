package pages.darekTask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class SingleProductGridPage extends BasePage {
    public SingleProductGridPage(WebElement singleProductInGrid) {
        PageFactory.initElements(new DefaultElementLocatorFactory(singleProductInGrid), this);
    }

    @FindBy(css = ".product-title a")
    WebElement singleProductFromGrid;

    @FindBy(css = ".thumbnail-container .product-flags .discount")
    WebElement discount;

    @FindBy(css = ".regular-price")
    WebElement regularPrice;

    @FindBy(css = ".price")
    WebElement priceAfterDiscount;

    public String getProductName() {
        return singleProductFromGrid.getText();
    }

    public void clickOnProduct(){
        singleProductFromGrid.click();
    }

    public String getRegularPrice(){
        return regularPrice.getText();
    }

    public String getPriceAfterDiscount(){
        return priceAfterDiscount.getText();
    }
}