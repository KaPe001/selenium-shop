package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class SingleDropdownResultList {
    public SingleDropdownResultList(WebElement singleResult) {
        PageFactory.initElements(new DefaultElementLocatorFactory(singleResult), this);
    }

    @FindBy(css = ".ui-menu-item a .product")
    WebElement result;

    public String getResultFromListName(){
        return result.getText();
    }
}