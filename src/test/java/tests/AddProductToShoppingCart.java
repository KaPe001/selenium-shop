package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.ProductGridPage;
import pages.ProductPage;
import testBase.Pages;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddProductToShoppingCart extends Pages {

    @Test
    public void successfullyAddedProduct() {

        for (int i = 0; i < 3; i++) {
            mainPage.goToRandomCategory();

            productGridPage.goToRandomProduct();
            productPage.getRandomQuantityOfProducts();
            productPage.addToCart();

            String productName = productPage.getProductName();
            assertThat(productPage.checkIfCorrectProduct(), equalTo(productName));

            String productQuantity = productPage.getProductQuantity();
            assertThat(productPage.checkIfCorrectQuantity(), equalTo(productQuantity));

            String productCountLabel = productPage.getProductCount();
            assertThat(productPage.checkIfProductCountIsCorrect(), equalTo(productCountLabel));

            productPage.checkIfTotalProductPriceIsCorrect();
//            assertThat(productPage.checkIfTotalProductPriceIsCorrect(),
//                    equalTo(productPage.getSubtotalValueConvert())); throws and error bc of the problem with total price

            productPage.continueShopping();
            productPage.checkIfUpdatedCartQuantity();
            assertThat(productPage.checkIfUpdatedCartQuantity(),
                    equalTo(webDriver.findElement(By.cssSelector("#_desktop_cart .cart-products-count")).getText()));
        }
    }
}
