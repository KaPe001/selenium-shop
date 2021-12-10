package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(id = "submit-login")
    WebElement submitBtn;

    @FindBy(css = ".user-info span")
    WebElement userNameDisplayed;

    @FindBy(className = "alert")
    WebElement validateText;

    @FindBy(css = ".no-account a")
    WebElement createNewAccountBtn;

    public LoginPage logUserIn(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitBtn.click();
        return this;
    }

    public void userExistsVerify(String nameAndLastName) {
        System.out.println(userNameDisplayed.getText());
        Assert.assertEquals(nameAndLastName, userNameDisplayed.getText());
    }

    public void whenUserDoesntExistGetAlert() {
        if (validateText.isDisplayed()) {
            System.out.println(validateText.getText() + " Going to user registration.");
            if (!validateText.getText().equals("Login success")) {
                createNewAccountBtn.click();
            }
        } else {
            System.out.println("Existing user logged in properly");
        }
    }
}
