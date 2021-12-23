package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class SingleCategoryOnMainPage extends BasePage {
    public SingleCategoryOnMainPage(WebElement singleCategory) {
        PageFactory.initElements(new DefaultElementLocatorFactory(singleCategory), this);
    }

    @FindBy(className = "dropdown-item")
    WebElement clothesCategory;

    @FindBy(css = "#top-menu > .category:nth-child(2) > .dropdown-item")
    WebElement accessoriesCategory;

    @FindBy(css = "#top-menu > .category:nth-child(3) > .dropdown-item")
    WebElement artCategory;

    public SingleCategoryOnMainPage goToCategory() {
        accessoriesCategory.click();
        return this;
    }

    public SingleCategoryOnMainPage getCategory(WebElement element) {
        element.click();
        return this;
    }

    public String getFirstCategoryName() {
        return clothesCategory.getText();
    }

    public String getSecondCategoryName() {
        return accessoriesCategory.getText();
    }

    public String getThirdCategoryName() {
        return artCategory.getText();
    }
}