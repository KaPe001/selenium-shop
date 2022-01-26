package tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pages.SingleProductInConfirmOrderPage;
import testBase.Pages;
import tests.helpers.CheckoutData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Checkout extends Pages {

    @Test
    public void checkoutOrder() {

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

        CheckoutData checkoutData = new CheckoutData();

        checkoutPage.fillInAddress(checkoutData.getAddress())
                .fillInZipCodeInput(checkoutData.getZipcode())
                .fillInCityInput(checkoutData.getCity())
                .selectCountry(checkoutData.getVisibleTextCountry())
                .continueCheckout()
                .continueOnShippingMethod()
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

        assertThat(orderDetailsPage.getDeliveryAddress().contains(checkoutData.getAddress()));
        assertThat(orderDetailsPage.getInvoiceAddress().contains(checkoutData.getAddress()));
    }
}
