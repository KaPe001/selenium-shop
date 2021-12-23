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

    public boolean areProductsDisplayedInBasket() {
        for (BasketProductPage basketProductPage : createNewProductsList()) {
            return basketProductPage.getProductName().contains(createNewProductsList().toString());
        }
        return true;
    }

    public String getProductNameFromBasket(){
        String name  = "";
        for(BasketProductPage basketProductPage : createNewProductsList()){
            name = basketProductPage.getProductName();
            System.out.println(name);
        }
        return name;
    }

    public String getProductPriceFormBasket(){
        String price = "";
        for(BasketProductPage basketProductPage : createNewProductsList()){
            price = basketProductPage.getProductPrice();
            System.out.println(price);
        }
        return price;
    }

    public String getProductQuantityFormBasket(){
        String quantity = "";
        for(BasketProductPage basketProductPage : createNewProductsList()){
            quantity = basketProductPage.getProductQuantity();
            System.out.println(quantity);
        }
        return quantity;
    }

    public String getTotalPriceFormBasket(){
        String totalPrice = "";
        for(BasketProductPage basketProductPage : createNewProductsList()){
            totalPrice = basketProductPage.getProductTotalPrice();
            System.out.println(totalPrice);
        }
        return totalPrice;
    }

}
