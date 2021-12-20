package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(css = "[id='header'] [id='_desktop_user_info'] .hidden-sm-down")
    WebElement logInBtn;

    @FindBy(css = ".user-info span")
    WebElement userNameDisplayed;

    @FindBy(css = ".user-info .logout")
    WebElement logOutBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        clickOnElement(logInBtn);
    }

    public String verifyLoggedUserInfo() {
        System.out.println(userNameDisplayed.getText());
        return userNameDisplayed.getText();
    }

    public void logUserOut() {
        clickOnElementToSignUserOut(logOutBtn);
        if (userNameDisplayed.getText().equals("Sign in")) {
            System.out.println("User signed out properly");
        }
    }

}
