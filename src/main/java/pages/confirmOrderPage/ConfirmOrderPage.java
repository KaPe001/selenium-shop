package pages.confirmOrderPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ConfirmOrderPage extends BasePage {

    @FindBy(css = "#order-items .order-confirmation-table .order-line")
    List<WebElement> productsList;

    @FindBy(css = "#order-details li:nth-child(2)")
    WebElement paymentMethod;

    @FindBy(css = "#order-details li:last-child")
    WebElement shippingMethod;

    @FindBy(css = "#order-details li:first-child")
    WebElement orderReferenceNo;

    @FindBy(css = ".user-info .account span")
    WebElement accountBtn;

    @FindBy(css = ".card-block dd")
    WebElement totalAmountToPay;

    public ConfirmOrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<SingleProductInConfirmOrderPage> createNewListOfProductsInConfirmOrder() {
        List<SingleProductInConfirmOrderPage> newListOfProductsInOrderConfirmation = new ArrayList<>();
        for (WebElement element : productsList) {
            newListOfProductsInOrderConfirmation.add(new SingleProductInConfirmOrderPage(element));
        }
        return newListOfProductsInOrderConfirmation;
    }

    public List<SingleProductInConfirmOrderPage> getListOfProducts(){
        List<SingleProductInConfirmOrderPage> newListOfProductsInOrderConfirmation = createNewListOfProductsInConfirmOrder();
        for(SingleProductInConfirmOrderPage singleProductInConfirmOrderPage : newListOfProductsInOrderConfirmation){
            String productName = singleProductInConfirmOrderPage.getProductName();
            System.out.println(productName + " = product name");
        }
        return newListOfProductsInOrderConfirmation;
    }

    public boolean areAllProductsAdded(){
        List<SingleProductInConfirmOrderPage> newOrderProductsList = createNewListOfProductsInConfirmOrder();
        for(SingleProductInConfirmOrderPage singleProductInConfirmOrderPage : newOrderProductsList){
            if(singleProductInConfirmOrderPage.productSingleLineName.isDisplayed()
                && singleProductInConfirmOrderPage.unitPrice.isDisplayed()
                && singleProductInConfirmOrderPage.totalProductsPrice.isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public String getDetailsOnPaymentMethod(){
        return paymentMethod.getText().replace("Payment method: ","");
    }

    public String getDetailsOnShippingMethod(){
        return shippingMethod.getText().replace("Shipping method: ","").replace("\nPick up in-store", "");
    }

    public String orderRefNumber(){
        return orderReferenceNo.getText().replace("Order reference: ","");
    }

    public String totalAmountToPay(){
        return removeCurrency(totalAmountToPay.getText());
    }

    public String shippingMethod(){
        return shippingMethod.getText().replace("Shipping method: ","").replace("\nPick up in-store", "");
    }

    public String paymentMethod(){
        return paymentMethod.getText().replace("Payment method: ","");
    }

    public ConfirmOrderPage goToYourAccount(){
        clickOnElement(accountBtn);
        return this;
    }
}
