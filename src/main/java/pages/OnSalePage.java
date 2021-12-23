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

    public String checkTitle(){
        return pageTitle.getText();
    }

    public void clickOnProduct(){
        clickOnElement(product);
    }
}
