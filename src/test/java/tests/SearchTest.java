package tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import testBase.Pages;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchTest extends Pages {

    @Test
    @Order(1)
    public void searchForProduct() {
        String productName = productGridPage.getRandomProductName();

        mainPage.searchProduct(productName)
                        .clickSearchIcon();

        assertTrue(productGridPage.isProductOnTheList(productName));
    }

    @Test
    @Order(2)
    public void searchResultInDropdown() {
        String productName = productGridPage.getRandomProductName();

        mainPage.searchProduct(productName);

        assertTrue(mainPage.isResultInResultDropDownList(productName));
    }
}
