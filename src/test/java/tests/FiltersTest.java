package tests;

import org.junit.jupiter.api.Test;
import testBase.Pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FiltersTest extends Pages {

    @Test
    public void checkFilters() {

        mainPage.goToArtCategory();
        categoryPage.useFilter();
        categoryPage.getAmountOfProducts();

        int gridSize = productGridPage.getProductGridSize();
        assertThat(categoryPage.getAmountOfProducts(), equalTo("(" + gridSize + ")"));

        filterPage.clearFilter();
    }
}
