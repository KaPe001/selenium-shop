package pages.darekTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(css = ".cart-overview li")
    List<WebElement> listOfProductsInBasket;

    @FindBy(css = ".cart-summary .checkout a")
    WebElement checkOutBtn;

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<BasketProductPage> createNewProductsList() {
        List<BasketProductPage> newProductsList = new ArrayList<>();
        for (WebElement element : listOfProductsInBasket) {
            newProductsList.add(new BasketProductPage(element));
        }
        return newProductsList;
    }

    public BasketPage proceedToCheckout(){
//        clickOnElement(checkOutBtn);
        retryOnStaleElement(checkOutBtn);
//        checkOutBtn.click();
        return this;
    }
}