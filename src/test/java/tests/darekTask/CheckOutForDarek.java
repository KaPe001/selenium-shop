package tests.darekTask;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import pages.LoginPage;
import pages.RegisterPage;
import pages.darekTask.*;
import testBase.darekTask.TestBaseForDarekTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckOutForDarek extends TestBaseForDarekTask {

    @RepeatedTest(1)
//    @Test
    public void checkoutOrder() {
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        RegisterPage registerPage = new RegisterPage(webDriver);
        ProductGridPage productGridPage = new ProductGridPage(webDriver);
        ProductPage productPage = new ProductPage(webDriver);
        BasketPage basketPage = new BasketPage(webDriver);
        CheckoutPage checkoutPage = new CheckoutPage(webDriver);
        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(webDriver);
        YourAccountPage yourAccountPage = new YourAccountPage(webDriver);
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(webDriver);
        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(webDriver);

        mainPage.goToLoginPage();
        loginPage.registerUser();
        registerPage.getUserGender()
                .getUserFirstNameLastName("Jan", "Kowalski")
                .getEmail()
                .getPassword("somePassword12345")
                .giveConsent()
                .saveUserRegistration();

        mainPage.goToArtCategory();
        productGridPage.goToProduct();
        productPage.getQuantity("10");
        productPage.addToCart();
        productPage.proceedToCheckout();
        basketPage.proceedToCheckout();

        String address = "Kwiatowa 15";
        String zipcode = "12-345";
        String city = "Rzeszów";
        String visibleTextCountry = "Poland";

        checkoutPage.fillInAddress(address)
                .fillInZipCodeInput(zipcode)
                .fillInCityInput(city)
                .selectCountry(visibleTextCountry)
                .continueCheckout()
                .payByBankWire()
                .conditionToApprove()
                .placeOrder();

        confirmOrderPage.getListOfProducts();
        assertTrue(confirmOrderPage.areAllProductsAdded());

        String expectedPaymentMethod = confirmOrderPage.paymentMethod();
        String expectedShippingMethod = confirmOrderPage.shippingMethod();

        assertThat(confirmOrderPage.getDetailsOnPaymentMethod(), equalTo(expectedPaymentMethod));
        assertThat(confirmOrderPage.getDetailsOnShippingMethod(), equalTo(expectedShippingMethod));

        String expectedReferenceNumber = confirmOrderPage.orderRefNumber();
        String expectedTotalPrice = confirmOrderPage.totalAmountToPay();

        confirmOrderPage.goToYourAccount();
        yourAccountPage.goToHistoryAndDetails();
        orderHistoryPage.printListWithOrders();

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = df.format(new Date());

        assertThat(orderHistoryPage.isOrderDateCorrect(), equalTo(currentDate));
        assertThat(orderHistoryPage.isOrderRefNumberCorrect(), equalTo(expectedReferenceNumber));
        assertThat(orderHistoryPage.isOrderTotalPriceCorrect(), equalTo(expectedTotalPrice));
        assertThat(orderHistoryPage.isPaymentMethodCorrect(), equalTo(expectedPaymentMethod));

        String expectedStatus = "Awaiting bank wire payment";
        assertThat(orderHistoryPage.isOrderStatusCorrect(), equalTo(expectedStatus));
        assertTrue(orderHistoryPage.isOrderCorrect());

        orderHistoryPage.goToOrderDetails();
        Assertions.assertThat(orderDetailsPage.getInvoiceAddress().contains(address));
    }
}
