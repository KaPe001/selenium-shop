package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class SingleSubCategoryOnMainPage extends BasePage {
    public SingleSubCategoryOnMainPage(WebElement subCategory){
        PageFactory.initElements(new DefaultElementLocatorFactory(subCategory), this);
    }
    @FindBy(css = "#top-menu > .category > .sub-menu > .top-menu > .category > .dropdown-submenu")
    WebElement singleSubCategory;

    public SingleSubCategoryOnMainPage getSubCategory(){
        return this;
    }
}
