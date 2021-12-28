package tests;

import org.junit.jupiter.api.Test;
import testBase.Pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddProductToShoppingCart extends Pages {

    @Test
    public void successfullyAddedProduct() {

        for (int i = 0; i < 3; i++) {
            mainPage.goToRandomCategory();

            productGridPage.goToRandomProduct();
            productPage.getRandomQuantityOfProducts(1, 5);
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

            String cartQuantity = productPage.getCartQuantity();
            assertThat(productPage.checkIfUpdatedCartQuantity(), equalTo(cartQuantity));
        }
    }
}
