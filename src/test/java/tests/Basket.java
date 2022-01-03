package tests;

import configuration.basket.BasketClass;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import testBase.Pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Basket extends Pages {

    @Test
    public void addProductsToBasket() {
        SoftAssertions softly = new SoftAssertions();

        BasketClass basketClass = new BasketClass();
        for (int i = 0; i < 5; i++) {
            mainPage.goToRandomCategory();

            productGridPage.goToRandomProduct();

            productPage.addToCart(basketClass);
            productPage.continueShopping();
        }

        mainPage.goToBasket();

        Assert.assertTrue(basketPage.areProductsDisplayedInBasket(basketClass));

        softly.assertThat(basketPage.getTotalPriceFromWebSite()).isEqualTo(basketClass.getSumOfAllProducts());

        basketPage.increaseQuantity("5", basketClass);
        softly.assertThat(basketPage.getTotalPriceFromWebSite()).isEqualTo(basketClass.getSumOfAllProducts());

        assertTrue(basketPage.doesArrowUpUpdateQuantity(basketClass));
        softly.assertThat(basketPage.getTotalPriceFromWebSite()).isEqualTo(basketClass.getSumOfAllProducts()); //total isn't correct on a page

        assertTrue(basketPage.doesArrowDownUpdateQuantity(basketClass));
        softly.assertThat(basketPage.getTotalPriceFromWebSite()).isEqualTo(basketClass.getSumOfAllProducts()); //total isn't correct on a page

        for(int i = 0; i < basketClass.getBasketProducts().size(); i++) {
            basketPage.deleteProduct(basketClass);
            softly.assertThat(basketPage.getTotalPriceFromWebSite()).isEqualTo(basketClass.getSumOfAllProducts());
        }
    }
}
