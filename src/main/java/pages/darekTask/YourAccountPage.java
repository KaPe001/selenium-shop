package pages.darekTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class YourAccountPage extends BasePage {

    @FindBy(css = ".links #history-link")
    WebElement historyBtn;

    public YourAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public YourAccountPage goToHistoryAndDetails(){
        clickOnElement(historyBtn);
        return this;
    }
}
