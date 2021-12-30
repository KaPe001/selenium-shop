package pages.darekTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = "[id='header'] [id='_desktop_user_info'] .hidden-sm-down")
    WebElement logInBtn;

    @FindBy(css = "#category-9 > a")
    WebElement art;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToLoginPage() {
        clickOnElement(logInBtn);
    }

    public void goToArtCategory() {
        clickOnElement(art);
    }
}