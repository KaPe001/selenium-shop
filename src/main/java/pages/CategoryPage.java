package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {

    @FindBy(css = "#js-product-list-header h1")
    WebElement categoryName;

    @FindBy(id = "search_filters")
    WebElement filtersInCategoryPage;

    @FindBy(css = "#products .total-products p")
    WebElement amountLabel;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryName() {
        return categoryName.getText();
    }

    public CategoryPage checkIfFilterMenuIsDisplayed() {
        if (!filtersInCategoryPage.isDisplayed()) {
            System.out.println("Filters aren't displayed");
            System.exit(1);
        }
        return this;
    }

    public String printHowManyProducts() {
        ProductGridPage productGridPage = new ProductGridPage(driver);
        waitUntil(amountLabel);

        if (productGridPage.createListOfProducts().size() == 1) {
            return "There is 1 product.";
        }
        return amountLabel.getText();
    }
}
