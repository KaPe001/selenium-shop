package tests;

import testBase.Pages;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends Pages {

    @Test
    public void searchForProduct() {
        String productName = productGridPage.getRandomProductName();

        mainPage.searchProduct(productName)
                        .clickSearchIcon();

        assertTrue(productGridPage.isProductOnTheList(productName));
    }

    @Test
    public void searchResultInDropdown() {
        String productName = productGridPage.getRandomProductName();

        mainPage.searchProduct(productName);

        assertTrue(mainPage.isResultInResultDropDownList(productName));

    }

}
