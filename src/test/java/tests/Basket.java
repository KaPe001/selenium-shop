package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductGridPage;
import pages.ProductPage;
import testBase.TestBase;

public class Basket extends TestBase {

    @Test
    public void addProductsToBasket() {
        MainPage mainPage = new MainPage(webDriver);
        ProductGridPage productGridPage = new ProductGridPage(webDriver);
        ProductPage productPage = new ProductPage(webDriver);
        BasketPage basketPage = new BasketPage(webDriver);

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
