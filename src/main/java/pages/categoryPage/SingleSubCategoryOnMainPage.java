package pages.categoryPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class SingleSubCategoryOnMainPage {
    public SingleSubCategoryOnMainPage(WebElement subCategory) {
        PageFactory.initElements(new DefaultElementLocatorFactory(subCategory), this);
    }

    @FindBy(css = "#top-menu > .category > .sub-menu > .top-menu > .category")
    List<WebElement> subCategory;

    public List<WebElement> getSubCategory() {
        return subCategory;
    }
}