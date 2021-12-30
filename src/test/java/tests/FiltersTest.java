package tests;

import testBase.Pages;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FiltersTest extends Pages {

    @Test
    public void checkFilters() {

        mainPage.goToArtCategory();

//        for(int i = 0; i < filterPage.createNewFilterList().size(); i++) {
            categoryPage.useFilter();
            categoryPage.getAmountOfProducts();

            int gridSize = productGridPage.getProductGridSize();
            assertThat(categoryPage.getAmountOfProducts(), equalTo("(" + gridSize + ")"));

            filterPage.clearFilter();
    }
}
