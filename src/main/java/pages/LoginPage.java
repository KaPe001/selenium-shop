package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logUserIn(String email, String password) {//no parameters
        sendKeysToElement(emailInput, email); //"email" and "password" below by System.getProperty("") from yaml file
        sendKeysToElement(passwordInput, password);
//        loginAction(emailBox, passwordBox, myUser);
        return this;
    }

    public LoginPage submitUser(){
        clickOnElement(submitBtn);
        return this;
    }

//    public LoginPage loginAction(WebElement emailBox, WebElement passwordBox, User user){
//        sendKeysToElement(emailBox, user.getEmail());
//        sendKeysToElement(passwordBox, user.getPassword());
//    }

//    public String getAccountName(){
//
//    }
    public String getAccountName() {
        waitUntil(userNameDisplayed);
        try {
            System.out.println(userNameDisplayed.getText()); //get text w try
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
}
