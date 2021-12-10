package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id='header'] [id='_desktop_user_info'] .hidden-sm-down")
    WebElement logInBtn;

    @FindBy(css = ".user-info span")
    WebElement userNameDisplayed;

    @FindBy(className = "logout")
    WebElement logOutBtn;

    public void goToLoginPage() {
        logInBtn.click();
    }

    public MainPage verifyLoggedUserInfo() {
        System.out.println(userNameDisplayed.getText());
        Assert.assertEquals("Jan Kowalski", userNameDisplayed.getText());
        return this;
    }

    public void logUserOut() throws InterruptedException {
        sleep(1500);
        logOutBtn.click();
        if (userNameDisplayed.getText().equals("Sign in")) {
            System.out.println("User signed out properly");
        }
    }
}
