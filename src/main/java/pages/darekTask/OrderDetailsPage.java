package pages.darekTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class OrderDetailsPage extends BasePage {

    @FindBy(css = "#delivery-address address")
    WebElement deliveryAddress;

    @FindBy(css = "#invoice-address address")
    WebElement invoiceAddress;

    public OrderDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getDeliveryAddress(){
        return deliveryAddress.getText();
    }

    public String getInvoiceAddress(){
        return invoiceAddress.getText();
    }
}
