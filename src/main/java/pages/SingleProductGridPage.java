package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class SingleProductGridPage {
    public SingleProductGridPage(WebElement singleProductInGrid){
        PageFactory.initElements(new DefaultElementLocatorFactory(singleProductInGrid), this);
    }

    @FindBy(css = "#js-product-list [itemprop='itemListElement']")
    WebElement singleProductFromGridName;

    public String getProduct(){
        return singleProductFromGridName.getText();
    }
}
