package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import testBase.Pages;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class ProductsAndCategoriesTest extends Pages {

    @Test
    public void iterateThroughCategories() {

        for (int i = 0; i < mainPage.createNewCategoryList().size(); i++) {
            mainPage.getCategoriesListIndex(i).click();

            String categoryName = categoryPage.getCategoryName();
            assertThat(categoryPage.getCategoryName(), equalTo(categoryName));
            log.info("Category name matches with clicked category");

            filterPage.checkIfFilterMenuIsDisplayed();
            log.info("Filters are displayed");

            String productGridSize = productGridPage.getProductGridSizeLabel();
            assertThat(categoryPage.printHowManyProducts(), equalTo(productGridSize));
            log.info("Amount of products in grid match with the label");
        }
    }

    @Test
    public void iterateThroughSubCategories() {
        for (int i = 0; i < mainPage.createNewCategoryList().size(); i++) {
            for(int j = 0; j < mainPage.createNewSubCategoryListDependingOnCategory(i).size(); j++){
                mainPage.mouseHoverOnElementFromList(mainPage.getCategoriesListIndex(i));
                mainPage.createNewSubCategoryListDependingOnCategory(i).get(j).click();

                String categoryName = categoryPage.getCategoryName();
                assertThat(categoryPage.getCategoryName(), equalTo(categoryName));
                log.info("Category name matches with clicked category");

                assertTrue(filterPage.checkIfFilterMenuIsDisplayed());
                log.info("Filters are displayed");

                String productGridSize = productGridPage.getProductGridSizeLabel();
                assertThat(categoryPage.printHowManyProducts(), equalTo(productGridSize));
                log.info("Amount of products in grid match with the label");
            }
        }
    }
}
