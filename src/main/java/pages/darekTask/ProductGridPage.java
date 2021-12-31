package pages.darekTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductGridPage extends BasePage {

    @FindBy(css = ".product")
    List<WebElement> productList;

    @FindBy(css = "#js-product-list .product:last-child a")
    WebElement singleProduct;

    public ProductGridPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<SingleProductGridPage> createListOfProducts() {
        List<SingleProductGridPage> newList = new ArrayList<>();
        for (WebElement element : productList) {
            newList.add(new SingleProductGridPage(element));
        }
        return newList;
    }

    public ProductGridPage goToProduct() {
        singleProduct.click();
//        clickOnElement(singleProduct);
        return this;
    }
}
