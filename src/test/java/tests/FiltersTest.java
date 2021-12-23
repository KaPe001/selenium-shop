package tests;

import testBase.Pages;
import testBase.TestBase;
import org.junit.jupiter.api.Test;
import pages.CategoryPage;
import pages.MainPage;
import pages.ProductGridPage;

public class FiltersTest extends Pages {

    @Test
    public void checkFilters() {
//        int gridSize = new ProductGridPage.createListOfProducts().size();

//        System.out.println(gridSize);

        new MainPage(webDriver)
                .goToArtCategory();

        new CategoryPage(webDriver)
                .useFilter()
                .getAmountOfProducts();
    }
}
