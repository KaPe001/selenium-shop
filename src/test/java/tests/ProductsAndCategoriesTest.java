package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.CategoryPage;
import pages.MainPage;
import pages.ProductGridPage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProductsAndCategoriesTest extends TestBase {

    @Test
    public void iterateThroughCategories() {
        CategoryPage categoryPage = new CategoryPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);
        ProductGridPage productGridPage = new ProductGridPage(webDriver);

        for (int i = 0; i < mainPage.createNewCategoryList().size(); i++) {
            clickOnElement(mainPage.getCategoriesListIndex(i));

            waitUntil(categoryPage.getCategory());
            assertThat(categoryPage.getCategoryName(),
                    equalTo(webDriver.findElement(By.cssSelector("#js-product-list-header h1")).getText()));
            logMessage("Category name matches with clicked category");

            categoryPage.checkIfFilterMenuIsDisplayed();
            logMessage("Filters are displayed");

            Assert.assertEquals(categoryPage.printHowManyProducts(),
                    (mainPage.getActualProductGridSize(productGridPage.createListOfProducts().size())));
            logMessage("Amount of products in grid match with the label");
        }
    }

    @Test
    public void iterateThroughSubCategories() {
        new MainPage(webDriver)
                .iterateThroughSubCategories();
    }
}
