package pages.darekTask;

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

//    @FindBy(css = ".delivery-options .custom-radio input")
//    WebElement shippingOption;
//
//    @FindBy(css = ".delivery-options-list button")
//    WebElement continueShippingMethod;

    @FindBy(css = "#conditions-to-approve .custom-checkbox input")
    WebElement termsAndConditions;

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
//        waitUntil(continueBtn);
        retryOnStaleElement(continueBtn);
//        clickRadioButton(continueBtn);
//        clickOnElement(continueBtn);
        return this;
    }

//    public CheckoutPage clickShippingOption(){
//        clickRadioButton(shippingOption);
//        return this;
//    }

//    public CheckoutPage continueOnShippingMethod(){
//        clickRadioButton(shippingOption);
////        waitUntil(continueShippingMethod);
//        clickRadioButton(continueShippingMethod);
//        return this;
//    }

    public CheckoutPage agreeOnTerms(){
        clickRadioButton(termsAndConditions);
        return this;
    }

    public CheckoutPage payByBankWire() {
        retryOnStaleElement(payByBankBtn);
//        if(paymentTitle.isDisplayed()) {
//            clickRadioButton(payByBankBtn);
//        }
        return this;
    }

    public CheckoutPage conditionToApprove(){
        retryOnStaleElement(conditionBtn);
//        clickRadioButton(conditionBtn);
        return this;
    }

    public CheckoutPage placeOrder(){
//        clickRadioButton(placeOrderBtn);
        retryOnStaleElement(placeOrderBtn);
//        clickOnElement(placeOrderBtn);
        return this;
    }
}
