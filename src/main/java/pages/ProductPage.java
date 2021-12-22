package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = ".product-container [itemprop = 'name']")
    WebElement productName;

    @FindBy(css = ".current-price .discount")
    WebElement discountLabel;

    @FindBy(css = ".product-prices .regular-price")
    WebElement regularPrice;

    @FindBy(css = ".product-prices .current-price span")
    WebElement priceAfterDiscount;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductName() {
        return productName.getText();
    }

    public ProductPage checkForLabel(){
        discountLabel.getText();
        return this;
    }

    public ProductPage checkIfRegularPriceIsDisplayed(){
        if(!regularPrice.isDisplayed()){
            logMessage("Something went wrong, price isn't displayed");
        }
        return this;
    }

    public ProductPage checkIfPriceAfterDiscountIsDisplayed(){
        if(!priceAfterDiscount.isDisplayed()){
            logMessage("Something went wrong, price isn't displayed");
        }
        return this;
    }

    public ProductPage calculateDiscount() {
        ProductGridPage productGridPage = new ProductGridPage(webDriver);
        productGridPage.calculateIfDiscountIsCorrect(regularPrice.getText(), priceAfterDiscount.getText());
        logMessage("Regular price on ProductPage is: 44.16, price after discount is: " + priceAfterDiscount.getText()
                + " which is - 20% on a regular price");
        return this;
    }
}
