package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends BasePage {

    @FindBy(className = "custom-radio")
    WebElement genderIdentificationBtn;

    @FindBy(name = "firstname")
    WebElement firstNameInput;

    @FindBy(name = "lastname")
    WebElement lastNameInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(className = "custom-checkbox")
    WebElement offersBtn;

    @FindBy(css = ".form-group:nth-child(8) .custom-checkbox")
    WebElement privacyBtn;

    @FindBy(css = ".form-group:nth-child(9) .custom-checkbox")
    WebElement newsletterBtn;

    @FindBy(css = ".form-group:nth-child(10) .custom-checkbox")
    WebElement acceptBtn;

    @FindBy(className = "btn-primary")
    WebElement saveBtn;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage getUserGender() {
        clickOnElement(genderIdentificationBtn);
        return this;
    }

    public RegisterPage getUserFirstNameLastName(String firstName, String lastName) {
        sendKeysToElement(firstNameInput, firstName);
        sendKeysToElement(lastNameInput, lastName);
        return this;
    }

    public RegisterPage getEmail() {
        String email = fakeValuesService.bothify("????##@gmail.com");
        sendKeysToElement(emailInput, email);
        return this;
    }

    public RegisterPage getPassword(String password) {
        sendKeysToElement(passwordInput, password);
        return this;
    }

    public RegisterPage giveConsent() {
        clickOnElement(offersBtn);
        clickOnElement(privacyBtn);
        clickOnElement(newsletterBtn);
        clickOnElement(acceptBtn);
        return this;
    }

    public void saveUserRegistration() {
        clickOnElement(saveBtn);
    }
}
