package pages.darekTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryPage extends BasePage {

    @FindBy(css = ".table tbody tr")
    List<WebElement> tableWithOrders;

    public OrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<RowWithOrdersPage> createNewOrdersList(){
        List<RowWithOrdersPage> ordersList = new ArrayList<>();
        for(WebElement element : tableWithOrders){
            ordersList.add(new RowWithOrdersPage(element));
        }
        return ordersList;
    }

    public List<RowWithOrdersPage> printListWithOrders(){
        List<RowWithOrdersPage> getList = createNewOrdersList();
        for(RowWithOrdersPage rowWithOrdersPage : getList){
            System.out.println(rowWithOrdersPage.getOrderReferenceNumber());
            System.out.println(rowWithOrdersPage.getOrderDate());
            System.out.println(rowWithOrdersPage.getOrderTotalPrice());
            System.out.println(rowWithOrdersPage.getOrderPayment());
            System.out.println(rowWithOrdersPage.getOrderStatus());
        }
        return getList;
    }

    public boolean isOrderCorrect(){
        List<RowWithOrdersPage> getList = createNewOrdersList();
        for(RowWithOrdersPage rowWithOrdersPage : getList){
            if(rowWithOrdersPage.orderReferenceNumber.isDisplayed()
                && rowWithOrdersPage.orderDate.isDisplayed()
                && rowWithOrdersPage.orderTotalPrice.isDisplayed()
                && rowWithOrdersPage.orderPayment.isDisplayed()
                && rowWithOrdersPage.orderStatus.isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public String isOrderDateCorrect(){
        String orderDate = "";
        List<RowWithOrdersPage> getList = createNewOrdersList();
        for(RowWithOrdersPage rowWithOrdersPage : getList){
            orderDate = rowWithOrdersPage.getOrderDate();
        }
        return orderDate;
    }

    public String isOrderRefNumberCorrect(){
        String orderRefNo = "";
        List<RowWithOrdersPage> getList = createNewOrdersList();
        for(RowWithOrdersPage rowWithOrdersPage : getList){
            orderRefNo = rowWithOrdersPage.getOrderReferenceNumber();
        }
        return orderRefNo;
    }

    public String isOrderTotalPriceCorrect(){
        String totalPrice = "";
        List<RowWithOrdersPage> getList = createNewOrdersList();
        for(RowWithOrdersPage rowWithOrdersPage : getList){
            totalPrice = rowWithOrdersPage.getOrderTotalPrice();
        }
        return totalPrice.replace("zł","");
    }

    public String isPaymentMethodCorrect(){
        String paymentMethod = "";
        List<RowWithOrdersPage> getList = createNewOrdersList();
        for(RowWithOrdersPage rowWithOrdersPage : getList){
            paymentMethod = rowWithOrdersPage.getOrderPayment();
        }
        return paymentMethod;
    }

    public String isOrderStatusCorrect(){
        String orderStatus = "";
        List<RowWithOrdersPage> getList = createNewOrdersList();
        for(RowWithOrdersPage rowWithOrdersPage : getList){
            orderStatus = rowWithOrdersPage.getOrderStatus();
        }
        return orderStatus;
    }

    public OrderHistoryPage goToOrderDetails(){
        List<RowWithOrdersPage> getList = createNewOrdersList();
        for(RowWithOrdersPage rowWithOrdersPage : getList){
//            waitUntil(rowWithOrdersPage.orderDetails);
//            rowWithOrdersPage.orderDetails.click();
            clickRadioButton(rowWithOrdersPage.orderDetails);
        }
        return this;
    }
}
