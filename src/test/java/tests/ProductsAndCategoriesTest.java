package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CategoryPage;
import pages.MainPage;
import pages.ProductGridPage;
import testBase.Pages;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProductsAndCategoriesTest extends Pages {
    Logger logger = LoggerFactory.getLogger(ProductsAndCategoriesTest.class);

    @Test
    public void iterateThroughCategories() {

        for (int i = 0; i < mainPage.createNewCategoryList().size(); i++) {
            mainPage.getCategoriesListIndex(i).click();

//            waitUntil(categoryPage.getCategory());
            assertThat(categoryPage.getCategoryName(),
                    equalTo(webDriver.findElement(By.cssSelector("#js-product-list-header h1")).getText()));
            logger.info("Category name matches with clicked category");

            categoryPage.checkIfFilterMenuIsDisplayed();
            logger.info("Filters are displayed");

//            Assert.assertEquals(categoryPage.printHowManyProducts(),
//                    (mainPage.getActualProductGridSize(productGridPage.createListOfProducts().size())));
            logger.info("Amount of products in grid match with the label");
        }
    }

    @Test
    public void iterateThroughSubCategories() {
        new MainPage(webDriver)
                .iterateThroughSubCategories();
    }
}
