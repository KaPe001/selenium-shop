package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OnSalePage extends BasePage {

    @FindBy(css = "#main #js-product-list-header")
    WebElement pageTitle;

    @FindBy(css = ".products .product .product-thumbnail")
    WebElement product;


    public OnSalePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkTitle(){
        if(pageTitle.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void clickOnProduct(){
        clickOnElement(product);
    }
}
