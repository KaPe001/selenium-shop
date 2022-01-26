package tests;

import configuration.basket.BasketClass;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import testBase.Pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddProductToShoppingCart extends Pages {
    SoftAssertions softly = new SoftAssertions();

    @Test
    public void successfullyAddedProduct() {
        BasketClass basketClass = new BasketClass();
        int addProducts = 3;

        for (int i = 0; i < addProducts; i++) {
            mainPage.goToRandomCategory();

            productGridPage.goToRandomProduct();
            productPage.getRandomQuantityOfProducts(1, 5);
            productPage.addToCart(basketClass);

            String productName = productPage.getProductName();
            assertThat(productPage.checkIfCorrectProduct(), equalTo(productName));

            String productQuantity = productPage.getProductQuantity();
            assertThat(productPage.checkIfCorrectQuantity(), equalTo(productQuantity));

            String productCountLabel = productPage.getProductCount();
            assertThat(productPage.checkIfProductCountIsCorrect(), equalTo(productCountLabel));

            softly.assertThat(productPage.getTotalValue()).isEqualTo(basketClass.getSumOfAllProducts());

            productPage.continueShopping();

            String cartQuantity = productPage.getCartQuantity();
            assertThat(productPage.checkIfUpdatedCartQuantity(), equalTo(cartQuantity));
        }
    }
}
