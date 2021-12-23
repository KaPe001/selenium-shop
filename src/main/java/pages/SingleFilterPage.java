package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class SingleFilterPage extends BasePage{
    public SingleFilterPage(WebElement singleFilter) {
        PageFactory.initElements(new DefaultElementLocatorFactory(singleFilter), this);
    }

    @FindBy(css = "#search_filters section:nth-child(3) .search-link")
    WebElement filter;

    public boolean isFilterDisplayed(){
        if(filter.isDisplayed()){
            return true;
        }
        return false;
    }

    public SingleFilterPage clickFilter(){
        clickOnElement(filter);
        return this;
    }
}
