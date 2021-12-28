package tests;

import org.junit.jupiter.api.Test;
import testBase.Pages;

public class Checkout extends Pages {

    @Test
    public void checkoutOrder(){
        mainPage.goToLoginPage();
        loginPage.registerUser();
        registerPage.getUserGender()
                .getUserFirstNameLastName("Jan", "Kowalski")
                .getEmail()
                .getPassword("somePassword12345")
                .giveConsent()
                .saveUserRegistration();

        for(int i = 0; i < 5; i++) {
            mainPage.goToRandomCategory();
            productGridPage.goToRandomProduct();
            productPage.getRandomQuantityOfProducts(1, 3);
            productPage.addToCart();
        }
        productPage.proceedToCheckout();
        basketPage.proceedToCheckout();

        checkoutPage.fillInAddress("Some address")
                .fillInZipCodeInput("12-345")
                .fillInCityInput("SomeCity")
                .selectCountry("Poland")
                .continueCheckout()
                .continueOnShippingMethod()
                .payByBankWire()
                .conditionToApprove()
                .placeOrder();
    }
}
