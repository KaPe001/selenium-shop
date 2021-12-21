package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductGridPage extends BasePage {
    String randomResult;

    @FindBy(css = "#js-product-list .products [itemprop='itemListElement']")
    List<WebElement> productList;

    public ProductGridPage(WebDriver driver) {
        super(driver);
    }

    public List<SingleProductGridPage> createListOfProducts() {
        List<SingleProductGridPage> newList = new ArrayList<>();
        for (WebElement element : productList) {
            newList.add(new SingleProductGridPage(element));
        }
        return newList;
    }

    public String getRandomProduct() {
        for (SingleProductGridPage singleProduct : createListOfProducts()) {
            int randomProduct = rnd.nextInt(createListOfProducts().size());
            randomResult = createListOfProducts().get(randomProduct).getProduct();
        }
        return randomResult;
    }
}
