package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FiltersPage extends BasePage{

    @FindBy(css = "#search_filters section:last-child li")
    List<WebElement> filtersInCategoryPage;

    @FindBy(css = "#products .total-products p")
    WebElement amountLabel;

    @FindBy(css = "#search_filters .facet .search-link .magnitude")
    WebElement amountOfProductsInFilterLabel;

    @FindBy(css = "#search_filters button")
    WebElement clearFilters;

    public FiltersPage(WebDriver webDriver){
        super(webDriver);
    }

    public List<SingleFilterPage> createNewFilterList(){
        List<SingleFilterPage> newFilterList = new ArrayList<>();
        for(WebElement element : filtersInCategoryPage){
            newFilterList.add(new SingleFilterPage(element));
        }
        return newFilterList;
    }

    public boolean checkIfFilterMenuIsDisplayed() {
        List<SingleFilterPage> newFilterList = createNewFilterList();
        for(SingleFilterPage singleFilterPage : newFilterList){
            waitUntil(singleFilterPage.filter);
            if(singleFilterPage.isFilterDisplayed()){
                return true;
            }
        }
        return false;
    }

    public FiltersPage clearFilter(){
        clickOnElement(clearFilters);
        return this;
    }
}
