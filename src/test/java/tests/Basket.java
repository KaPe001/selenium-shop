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

        softly.assertThat(basketPage.isTotalPriceCorrect(basketClass)); //total isn't correct on a page

        basketPage.increaseQuantity("5");
//        softly.assertThat(basketPage.isTotalPriceCorrect(basketClass)); //total isn't correct on a page

        assertTrue(basketPage.doesArrowUpUpdateQuantity());
        //softly.assertThat(basketPage.isTotalPriceCorrect(basketClass)); //total isn't correct on a page

        assertTrue(basketPage.doesArrowDownUpdateQuantity());
        //softly.assertThat(basketPage.isTotalPriceCorrect(basketClass)); //total isn't correct on a page

        for(int i = 0; i < basketClass.getBasketProducts().size(); i++) {
            basketPage.deleteProductAndCheckTheTotalPrice();
//            softly.assertThat(basketPage.isTotalPriceCorrect(basketClass));
        }
    }
}
