package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class CategoryPage extends BasePage {
    ProductGridPage productGridPage = new ProductGridPage(webDriver);
    FiltersPage filtersPage = new FiltersPage(webDriver);

    @FindBy(css = "#js-product-list-header h1")
    WebElement categoryName;

    @FindBy(css = "#js-active-search-filters")
    WebElement activeFiltersLabel;

    public CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getCategoryName() {
        return categoryName.getText();
    }

    public WebElement getCategory(){
        return categoryName;
    }

    public String printHowManyProducts() {
        waitUntil(filtersPage.amountLabel);
        productGridPage.getProductGridSizeLabel();
        return filtersPage.amountLabel.getText();
    }

    public CategoryPage useFilter() throws InterruptedException {
        List<SingleFilterPage> newFilterList = filtersPage.createNewFilterList();
        clickOnElement(newFilterList.get(rnd.nextInt(newFilterList.size())).filter);

        sleep(1500);
        waitUntil(activeFiltersLabel);
        return this;
    }

    public String getAmountOfProducts(){
        return filtersPage.amountOfProductsInFilterLabel.getText().replace("()","");
    }
}
