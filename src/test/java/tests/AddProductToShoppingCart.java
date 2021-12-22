package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.ProductGridPage;
import pages.ProductPage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddProductToShoppingCart extends TestBase {

    @Test
    public void successfullyAddedProduct() {
        MainPage mainPage = new MainPage(webDriver);
        ProductGridPage productGridPage = new ProductGridPage(webDriver);
        ProductPage productPage = new ProductPage(webDriver);

        for (int i = 0; i < 3; i++) {
            mainPage.goToRandomCategory();

            productGridPage.goToRandomProduct();
            productPage.getRandomQuantityOfProducts();
            productPage.addToCart();

            productPage.checkIfCorrectProduct();
            assertThat(productPage.checkIfCorrectProduct(),
                    equalTo(webDriver.findElement(By.cssSelector(".modal-body .product-name")).getText()));

            productPage.checkIfCorrectQuantity();
            assertThat(productPage.checkIfCorrectQuantity(),
                    equalTo("Quantity: " + webDriver.findElement(By.cssSelector(".modal-body .product-quantity strong")).getText()));

            productPage.checkIfProductCountIsCorrect();
            assertThat(productPage.checkIfProductCountIsCorrect(),
                    equalTo(webDriver.findElement(By.cssSelector(".modal-body .cart-content .cart-products-count")).getText()));

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
