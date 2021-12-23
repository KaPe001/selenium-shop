package testBase;

import org.junit.jupiter.api.BeforeEach;
import pages.*;

public class Pages extends TestBase {
    public MainPage mainPage;
    public ProductGridPage productGridPage;
    public ProductPage productPage;
    public CategoryPage categoryPage;
    public BasketPage basketPage;

    @BeforeEach
    public void setUpPages() {
        mainPage  = new MainPage(webDriver);
        productGridPage = new ProductGridPage(webDriver);
        productPage = new ProductPage(webDriver);
        categoryPage= new CategoryPage(webDriver);
        basketPage = new BasketPage(webDriver);
    }
}
