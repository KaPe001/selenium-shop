package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class RowWithOrdersPage {
    public RowWithOrdersPage(WebElement row){
        PageFactory.initElements(new DefaultElementLocatorFactory(row), this);
    }

    @FindBy(css = "th")
    WebElement orderReferenceNumber;

    @FindBy(css = "td")
    WebElement orderDate;

    @FindBy(css = ".text-xs-right")
    WebElement orderTotalPrice;

    @FindBy(css = ".hidden-md-down")
    WebElement orderPayment;

    @FindBy(css = ".label-pill")
    WebElement orderStatus;

    @FindBy(css = ".order-actions a")
    WebElement orderDetails;

    public String getOrderReferenceNumber(){
        return orderReferenceNumber.getText();
    }

    public String getOrderDate(){
        return orderDate.getText();
    }

    public String getOrderTotalPrice(){
        return orderTotalPrice.getText();
    }

    public String getOrderPayment(){
        return orderPayment.getText();
    }

    public String getOrderStatus(){
        return orderStatus.getText();
    }
}
