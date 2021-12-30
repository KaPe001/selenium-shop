package testBase;

import org.junit.jupiter.api.BeforeEach;
import pages.*;

public class Pages extends TestBase {
    public MainPage mainPage;
    public ProductGridPage productGridPage;
    public ProductPage productPage;
    public CategoryPage categoryPage;
    public BasketPage basketPage;
    public FiltersPage filterPage;
    public OnSalePage onSalePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public CheckoutPage checkoutPage;
    public ConfirmOrderPage confirmOrderPage;
    public YourAccountPage yourAccountPage;
    public OrderHistoryPage orderHistoryPage;
    public OrderDetailsPage orderDetailsPage;

    @BeforeEach
    public void setUpPages() {
        mainPage  = new MainPage(webDriver);
        productGridPage = new ProductGridPage(webDriver);
        productPage = new ProductPage(webDriver);
        categoryPage= new CategoryPage(webDriver);
        basketPage = new BasketPage(webDriver);
        filterPage = new FiltersPage(webDriver);
        onSalePage = new OnSalePage(webDriver);
        registerPage = new RegisterPage(webDriver);
        loginPage = new LoginPage(webDriver);
        checkoutPage = new CheckoutPage(webDriver);
        confirmOrderPage = new ConfirmOrderPage(webDriver);
        yourAccountPage = new YourAccountPage(webDriver);
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderDetailsPage = new OrderDetailsPage(webDriver);
    }
}
