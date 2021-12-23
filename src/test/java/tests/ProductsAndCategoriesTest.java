package tests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testBase.Pages;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProductsAndCategoriesTest extends Pages {
    Logger logger = LoggerFactory.getLogger(ProductsAndCategoriesTest.class);

    @Test
    public void iterateThroughCategories() {

        for (int i = 0; i < mainPage.createNewCategoryList().size(); i++) {
            mainPage.getCategoriesListIndex(i).click(); //create a click method in mainPage

            String categoryName = categoryPage.getCategoryName();
            assertThat(categoryPage.getCategoryName(), equalTo(categoryName));
            logger.info("Category name matches with clicked category");

            filterPage.checkIfFilterMenuIsDisplayed();
            logger.info("Filters are displayed");

            String productGridSize = productGridPage.getProductGridSizeLabel();
            assertThat(categoryPage.printHowManyProducts(), equalTo(productGridSize));
            logger.info("Amount of products in grid match with the label");
        }
    }

    @Test
    public void iterateThroughSubCategories() {
        for (int i = 0; i < mainPage.createNewCategoryList().size(); i++) {
            for(int j = 0; j < mainPage.createNewSubCategoryListDependingOnCategory(i).size(); j++){
                mainPage.mouseHoverOnElementFromList(mainPage.getCategoriesListIndex(i));
                mainPage.createNewSubCategoryListDependingOnCategory(i).get(j).click(); //create a click method in mainPage

                String categoryName = categoryPage.getCategoryName();
                assertThat(categoryPage.getCategoryName(), equalTo(categoryName));
                logger.info("Category name matches with clicked category");

                filterPage.checkIfFilterMenuIsDisplayed();
                logger.info("Filters are displayed");

                String productGridSize = productGridPage.getProductGridSizeLabel();
                assertThat(categoryPage.printHowManyProducts(), equalTo(productGridSize));
                logger.info("Amount of products in grid match with the label");
            }
        }
    }
}
