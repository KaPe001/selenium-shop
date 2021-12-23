package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductGridPage;
import pages.ProductPage;
import testBase.Pages;
import testBase.TestBase;

public class Basket extends Pages {

    @Test
    public void addProductsToBasket() {

        for(int i = 0; i < 5; i++) {
            mainPage.goToRandomCategory();

            productGridPage.goToRandomProduct();

            productPage.addToCart();
            productPage.continueShopping();
        }

        mainPage.goToBasket();

        basketPage.areProductsDisplayedInBasket();
        Assert.assertTrue(basketPage.areProductsDisplayedInBasket());
    }
}
