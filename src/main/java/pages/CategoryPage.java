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

    @FindBy(css = "#search_filters .facet .search-link")
    WebElement filerDimension;

    @FindBy(css = "#search_filters .facet .search-link .magnitude")
    WebElement amountOfProductsInFilterLabel;

    public CategoryPage(WebDriver webDriver) {
        super(webDriver);
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
        ProductGridPage productGridPage = new ProductGridPage(webDriver);
        waitUntil(amountLabel);

        if (productGridPage.createListOfProducts().size() == 1) {
            return "There is 1 product.";
        }
        return amountLabel.getText();
    }

    public CategoryPage useFilter(){
        clickOnElement(filerDimension);
        return this;
    }

    public String getAmountOfProducts(){
        return amountOfProductsInFilterLabel.getText();
    }
}
