package pages.categoryPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.basePage.BasePage;

public class SingleFilterPage extends BasePage {
    public SingleFilterPage(WebElement singleFilter) {
        PageFactory.initElements(new DefaultElementLocatorFactory(singleFilter), this);
    }

    @FindBy(css = ".facet-label a")
    WebElement filter;

    public boolean isFilterDisplayed(){
        return filter.isDisplayed();
    }

    public SingleFilterPage clickFilter(){
        clickOnElement(filter);
        return this;
    }
}
