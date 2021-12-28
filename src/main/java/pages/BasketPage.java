package pages;

import configuration.basket.BasketClass;
import configuration.basket.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(css = ".cart-overview li")
    List<WebElement> listOfProductsInBasket;

    @FindBy(css = ".cart-summary .card-block:nth-child(2) .value")
    WebElement totalPrice;

    @FindBy(css = ".cart-summary .checkout a")
    WebElement checkOutBtn;

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<BasketProductPage> createNewProductsList() {
        List<BasketProductPage> newProductsList = new ArrayList<>();
        for (WebElement element : listOfProductsInBasket) {
            newProductsList.add(new BasketProductPage(element));
        }
        return newProductsList;
    }

    public boolean areProductsDisplayedInBasket() {
        List<BasketProductPage> newProductsList = createNewProductsList();
        for (BasketProductPage basketProductPage : newProductsList) {
            basketProductPage.getProductName().contains(newProductsList.toString());
        }
            return true;
    }

    public boolean isTotalPriceCorrect() {
        String totalPriceForAllProducts = totalPrice.getText().replace("zł", "");
        return totalPriceForAllProducts.equals(Order.getTotalCost().toString());
    }

    public void printTotalPrice(){
        BasketClass basketClass = new BasketClass();
        String totalPriceForAllProducts = totalPrice.getText().replace("zł", "");

        System.out.println(totalPriceForAllProducts);
        System.out.println(Order.getTotalCost().toString());
    }

    public BasketPage proceedToCheckout(){
        clickOnElement(checkOutBtn);
        return this;
    }


    public String getProductNameFromBasket() {
        String name = "";
        for (BasketProductPage basketProductPage : createNewProductsList()) {
            name = basketProductPage.getProductName();
            System.out.println(name);
        }
        return name;
    }

    public String getProductPriceFormBasket() {
        String price = "";
        for (BasketProductPage basketProductPage : createNewProductsList()) {
            price = basketProductPage.getProductPrice();
            System.out.println(price);
        }
        return price;
    }

    public String getProductQuantityFormBasket() {
        String quantity = "";
        for (BasketProductPage basketProductPage : createNewProductsList()) {
            quantity = basketProductPage.getProductQuantity();
            System.out.println(quantity);
        }
        return quantity;
    }

    public String getTotalPriceFormBasket() {
        String totalPrice = "";
        for (BasketProductPage basketProductPage : createNewProductsList()) {
            totalPrice = basketProductPage.getProductTotalPrice();
            System.out.println(totalPrice);
        }
        return totalPrice;
    }
}
