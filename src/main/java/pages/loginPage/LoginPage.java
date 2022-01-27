package pages.loginPage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(className = "btn-primary")
    WebElement submitBtn;

    @FindBy(css = ".user-info span")
    WebElement userNameDisplayed;

    @FindBy(className = "alert")
    WebElement validateText;

    @FindBy(css = ".no-account a")
    WebElement createNewAccountBtn;

    @FindBy(css = "#content > .no-account a")
    WebElement registerUserBtn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage logUserIn(String email, String password) {//no parameters
        sendKeysToElement(emailInput, email); //"email" and "password" below by System.getProperty("") from yaml file
        sendKeysToElement(passwordInput, password);
        return this;
    }

    public LoginPage submitUser(){
        clickOnElement(submitBtn);
        return this;
    }

    public String getAccountName() {
        waitUntil(userNameDisplayed);
        try {
            System.out.println(userNameDisplayed.getText());
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        return userNameDisplayed.getText();
    }

    public void getAlert() {
        waitUntil(validateText);
        if (validateText.isDisplayed()) {
            System.out.println(validateText.getText() + " Going to user registration.");
            if (!validateText.getText().equals(" ")) {
                createNewAccountBtn.click();
            }
        } else {
            System.out.println("Existing user logged in properly");
        }
    }

    public LoginPage registerUser(){
        waitUntil(registerUserBtn);
        clickOnElement(registerUserBtn);
        return this;
    }
}
