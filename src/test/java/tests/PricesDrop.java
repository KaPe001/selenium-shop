package tests;

import org.junit.jupiter.api.Test;
import testBase.Pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PricesDrop extends Pages {

    @Test
    public void checkPricesDrop(){

        mainPage.clickOnBanner();
        assertTrue(onSalePage.checkTitle());

        assertTrue(productGridPage.isDiscountFromProductsDisplayed());

        assertTrue(productGridPage.isRegularPriceIsDisplayed());
        assertTrue(productGridPage.isPriceAfterDiscountPriceIsDisplayed());

        assertTrue(productGridPage.calculateIfDiscountIsCorrect());

        productGridPage.openOneOfDiscountedProducts();

        assertTrue(productPage.isDiscountLabelDisplayed());
        assertTrue(productPage.isRegularPriceIsDisplayed());
        assertTrue(productPage.isPriceAfterDiscountIsDisplayed());

        String regularPrice = productPage.getRegularPrice();
        String priceAfterDiscount = productPage.getPriceAfterDiscount();
        assertTrue(productPage.isPriceAfterDiscountCorrect(regularPrice, priceAfterDiscount));
    }
}
