package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(css = ".cart-overview .cart-items .cart-item")
    List<WebElement> listOfProductsInBasket;

    public BasketPage(WebDriver webDriver){
        super(webDriver);
    }

    public List<BasketProductPage> createNewProductsList(){
        List<BasketProductPage> newProductsList = new ArrayList<>();
        for(WebElement element : listOfProductsInBasket){
            newProductsList.add(new BasketProductPage(element));
        }
        return newProductsList;
    }

    public String printNewList(){
        String list  = "";
        for(BasketProductPage basketProductPage : createNewProductsList()){
            list = basketProductPage.getProductName() + basketProductPage.getProductPrice()
                    + basketProductPage.getProductQuantity() + basketProductPage.getProductTotalPrice();
            System.out.println(list);
        }
        return list;
    }
}
