package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import testBase.Pages;

public class Basket extends Pages {

    @Test
    public void addProductsToBasket() {
        for (int i = 0; i < 5; i++) {
            mainPage.goToRandomCategory();

            productGridPage.goToRandomProduct();

            productPage.addToCart();
            productPage.continueShopping();
        }

        mainPage.goToBasket();
        basketPage.printTotalPrice();

        Assert.assertTrue(basketPage.areProductsDisplayedInBasket());
        Assert.assertTrue(basketPage.isTotalPriceCorrect());
    }
}
