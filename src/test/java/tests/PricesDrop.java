package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import testBase.TestBase;

public class PricesDrop extends TestBase {

    @Test
    public void checkPricesDrop(){
        ProductGridPage productGridPage = new ProductGridPage(webDriver);
        ProductPage productPage = new ProductPage(webDriver);

        new MainPage(webDriver)
                .clickOnBanner();

        new OnSalePage(webDriver)
                .checkTitle();

        new ProductGridPage(webDriver)
                .getDiscountFromProducts();

        new ProductGridPage(webDriver)
                .checkIfRegularPriceIsDisplayed()
                .checkIfPriceAfterDiscountPriceIsDisplayed()
                .calculateIfDiscountIsCorrect(productGridPage.getRegularPrice(), productGridPage.getPriceAfterDiscount());

        new OnSalePage(webDriver)
                .clickOnProduct();

        new ProductPage(webDriver)
                .checkForLabel()
                .checkIfRegularPriceIsDisplayed()
                .checkIfPriceAfterDiscountIsDisplayed()
                .calculateDiscount();
    }
}
