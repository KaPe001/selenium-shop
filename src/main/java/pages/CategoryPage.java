package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    public CategoryPage useFilter() {
        List<SingleFilterPage> newFilterList = filtersPage.createNewFilterList();
        clickOnElement(newFilterList.get(rnd.nextInt(newFilterList.size())).filter);
        waitUntil(activeFiltersLabel);
        return this;
    }

    public String getAmountOfProducts(){
        if(!activeFiltersLabel.isDisplayed()) {
            (new WebDriverWait(webDriver, Duration.ofSeconds(15))).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return activeFiltersLabel.getText().length() != 0;
                }
            });
        }
        return filtersPage.amountOfProductsInFilterLabel.getText().replace("()","");
    }
}
