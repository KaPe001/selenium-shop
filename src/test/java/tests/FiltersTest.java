package tests;

import testBase.TestBase;
import org.junit.jupiter.api.Test;
import pages.CategoryPage;
import pages.MainPage;
import pages.ProductGridPage;

public class FiltersTest extends TestBase {

    @Test
    public void checkFilters() {
        CategoryPage categoryPage = new CategoryPage(webDriver);
        ProductGridPage productGridPage = new ProductGridPage(webDriver);

        int gridSize = productGridPage.createListOfProducts().size();

        System.out.println(gridSize);

        new MainPage(webDriver)
                .goToArtCategory();

        new CategoryPage(webDriver)
                .useFilter()
                .getAmountOfProducts();

        //Assert.assertEquals(categoryPage.getAmountOfProducts(), equalTo(gridSize));

    }
}
