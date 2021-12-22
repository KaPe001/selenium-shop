package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class SingleCategoryPage {
    public SingleCategoryPage(WebElement oneCategory) {
        PageFactory.initElements(new DefaultElementLocatorFactory(oneCategory), this);
    }

    @FindBy(css = ".top-menu .category")
    WebElement singleProductFromGrid;

    public String getProductName() {
        return singleProductFromGrid.getText();
    }
}