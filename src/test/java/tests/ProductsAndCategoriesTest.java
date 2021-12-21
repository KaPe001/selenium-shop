package tests;

import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class ProductsAndCategoriesTest extends TestBase {

    @Test
    public void iterateThroughCategories() {
        new MainPage(webDriver)
                .iterateThroughAllCategories();
    }

    @Test
    public void iterateThroughSubCategories(){
        new MainPage(webDriver)
                .iterateThroughSubCategories();
    }
}
