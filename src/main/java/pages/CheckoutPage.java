package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    @FindBy(css = ".form-fields div [name='address1']")
    WebElement addressInput;

    @FindBy(css = ".form-fields div [name='city']")
    WebElement cityInput;

    @FindBy(css = ".form-fields div [name='postcode']")
    WebElement zipCodeInput;

    @FindBy(css = ".form-fields div [name='id_country']")
    WebElement countrySelect;

    @FindBy(css = ".form-footer button")
    WebElement continueBtn;

    @FindBy(css = ".delivery-options-list button")
    WebElement continueShippingMethod;

    @FindBy(css = "#checkout-payment-step .step-title")
    WebElement paymentTitle;

    @FindBy(css = ".payment-options #payment-option-2-container input")
    WebElement payByBankBtn;

    @FindBy(css = "#conditions-to-approve input")
    WebElement conditionBtn;

    @FindBy(css = "#payment-confirmation button")
    WebElement placeOrderBtn;

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutPage fillInAddress(String address){
        waitUntil(addressInput);
        sendKeysToElement(addressInput, address);
        return this;
    }

    public CheckoutPage fillInCityInput(String city){
        waitUntil(cityInput);
        sendKeysToElement(cityInput, city);
        return this;
    }

    public CheckoutPage fillInZipCodeInput(String zipCode){
        waitUntil(zipCodeInput);
        sendKeysToElement(zipCodeInput, zipCode);
        return this;
    }

    public CheckoutPage selectCountry(String country){
        new Select(countrySelect).selectByVisibleText(country);
        return this;
    }

    public CheckoutPage continueCheckout(){
        waitUntil(continueBtn);
        clickOnElement(continueBtn);
        return this;
    }

    public CheckoutPage continueOnShippingMethod(){
        waitUntil(continueShippingMethod);
        clickOnElement(continueShippingMethod);
        return this;
    }

    public CheckoutPage payByBankWire() {
        if(paymentTitle.isDisplayed()) {
            clickRadioButton(payByBankBtn);
        }
        return this;
    }

    public CheckoutPage conditionToApprove(){
        clickRadioButton(conditionBtn);
        return this;
    }

    public CheckoutPage placeOrder(){
        clickOnElement(placeOrderBtn);
        return this;
    }
}
