package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductGridPage;
import pages.ProductPage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

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

//        String productName = webDriver.findElement(By.cssSelector(".product-line-grid .product-line-info a")).getText();
//        String productPrice = webDriver.findElement(By.cssSelector(".product-line-grid .product-line-info .price")).getText();
//        String productQuantity = webDriver.findElement(By.cssSelector(".product-line-grid .product-line-grid-right input")).getText();
//        String totalPrice = webDriver.findElement(By.cssSelector(".product-line-grid .product-line-grid-right .product-price strong")).getText();
//
//        assertThat(basketPage.getProductNameFromBasket(), equalTo(productName));
//        assertThat(basketPage.getProductPriceFormBasket(), equalTo(productPrice));
//        assertThat(basketPage.getProductQuantityFormBasket(), equalTo(productQuantity));
//        assertThat(basketPage.getTotalPriceFormBasket(), equalTo(totalPrice));
    }
}
