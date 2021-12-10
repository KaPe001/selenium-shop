package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

import static java.lang.Thread.sleep;

public class RegisterPage {
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".custom-radio input")
    WebElement genderIdentificationBtn;

    @FindBy(name = "firstname")
    WebElement firstNameInput;

    @FindBy(name = "lastname")
    WebElement lastNameInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(name = "optin")
    WebElement offersBtn;

    @FindBy(name = "customer_privacy")
    WebElement privacyBtn;

    @FindBy(name = "newsletter")
    WebElement newsletterBtn;

    @FindBy(name = "psgdpr")
    WebElement acceptBtn;

    @FindBy(className = "btn-primary")
    WebElement saveBtn;

    public RegisterPage getUserGender() throws InterruptedException {
        sleep(1500);
        genderIdentificationBtn.click();
        return this;
    }

    public RegisterPage getUserFirstNameLastName(String firstName, String lastName) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterPage getEmail() {
        Random rnd = new Random();
        int randomInt = rnd.nextInt(1000);
        emailInput.sendKeys("randomEmail" + randomInt + "@gmail.com");
        return this;
    }

    public RegisterPage getPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterPage giveConsent() {
        offersBtn.click();
        privacyBtn.click();
        newsletterBtn.click();
        acceptBtn.click();
        return this;
    }

    public void saveUserRegistration() {
        saveBtn.click();
    }
}
