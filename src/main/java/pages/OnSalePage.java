package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnSalePage extends BasePage {

    @FindBy(css = "#main #js-product-list-header")
    WebElement pageTitle;

    public OnSalePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkTitle(){
        return pageTitle.isDisplayed();
    }
}
