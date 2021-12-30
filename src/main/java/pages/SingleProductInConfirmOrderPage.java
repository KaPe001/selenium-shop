package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.darekTask.BasePage;

import static pages.BasePage.removeCurrency;

public class SingleProductInConfirmOrderPage extends BasePage {
    public SingleProductInConfirmOrderPage(WebElement product){
        PageFactory.initElements(new DefaultElementLocatorFactory(product), this);
    }

    @FindBy(css = ".details span")
    WebElement productSingleLineName;

    @FindBy(css = ".text-xs-left")
    WebElement unitPrice;

    @FindBy(css = ".text-xs-right")
    WebElement totalProductsPrice;

    public String getProductName(){
        return productSingleLineName.getText();
    }

    public String getProductUnitPrice(){
        return removeCurrency(unitPrice.getText());
    }

    public String getProductTotalPrice(){
        return removeCurrency(totalProductsPrice.getText());
    }

}
