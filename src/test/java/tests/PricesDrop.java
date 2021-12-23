package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import testBase.Pages;
import testBase.TestBase;

public class PricesDrop extends Pages {

    @Test
    public void checkPricesDrop(){

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
                .checkIfPriceAfterDiscountIsDisplayed();
//                .calculateDiscount();
    }
}
