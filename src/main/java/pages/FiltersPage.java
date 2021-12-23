package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FiltersPage extends BasePage{

    @FindBy(id = "search_filters")
    List<WebElement> filtersInCategoryPage;

    @FindBy(css = "#products .total-products p")
    WebElement amountLabel;

    @FindBy(css = "#search_filters .facet .search-link")
    WebElement filerDimension;

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

    public FiltersPage checkIfFilterMenuIsDisplayed() {
        List<SingleFilterPage> newFilterList = createNewFilterList();
        for(SingleFilterPage singleFilterPage : newFilterList){
            if(!singleFilterPage.isFilterDisplayed()){
                System.out.println("Filters aren't displayed");
                System.exit(1);
            }
        }
        return this;
    }

    public FiltersPage clearFilter(){
        clickOnElement(clearFilters);
        return this;
    }
}
