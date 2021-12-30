package pages;

import configuration.basket.BasketClass;
import configuration.basket.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(css = ".cart-overview li")
    List<WebElement> listOfProductsInBasket;

    @FindBy(css = ".cart-detailed-totals #cart-subtotal-products .value")
    WebElement productTotalPrice;

    @FindBy(css = ".cart-summary .checkout a")
    WebElement checkOutBtn;

    @FindBy(css = ".product-line-grid .js-increase-product-quantity .material-icons")
    WebElement arrowUpOnQuantity;

    @FindBy(css = ".product-line-grid .js-decrease-product-quantity .material-icons")
    WebElement arrowDownOnQuantity;

    @FindBy(css = ".product-line-grid .product-line-grid-right input")
    WebElement productQuantity;

    @FindBy(css = ".cart-summary .cart-summary-line .js-subtotal")
    WebElement totalItems;

    @FindBy(css = ".product-line-grid .product-line-grid-right .product-price strong")
    WebElement singleProductTotalPrice;

    @FindBy(css = ".product-line-grid-right a")
    WebElement deleteProduct;

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

    public boolean areProductsDisplayedInBasket(BasketClass basketClass) {
        List<BasketProductPage> newProductsList = createNewProductsList();
        for (BasketProductPage basketProductPage : newProductsList) {
            for(Product product : basketClass.getBasketProducts().keySet()) {
                if(product.getName().equals(basketProductPage.getProductName())){
                    return true;
                }
            }
        }
            return false;
    }

    public boolean isTotalPriceCorrect(BasketClass basketClass) {
        return basketClass.getSumOfAllProducts().toString().equals(getTotalPriceFromBasket());
    }

    public BasketPage proceedToCheckout(){
        clickOnElement(checkOutBtn);
        return this;
    }

    public BigDecimal getTotalPriceFromBasket() {
        BigDecimal totalPrice = new BigDecimal("0.00");
        for(int i = 0; i <= listOfProductsInBasket.size(); i++){
            int quantity = listOfProductsInBasket.size();
            BigDecimal price = new BigDecimal(String.valueOf(getSingleProductPrice().get(i)));
            totalPrice = price.multiply(BigDecimal.valueOf(quantity));
            System.out.println(totalPrice);
        }
        return totalPrice;
    }

    public List<BasketProductPage> getSingleProductPrice(){
        List<BasketProductPage> listOfProductsInBasket = createNewProductsList();
        for(BasketProductPage basketProductPage : listOfProductsInBasket){
            basketProductPage.getProductTotalPrice();
        }
        return listOfProductsInBasket;
    }

    public BasketPage increaseQuantity(String expectedQuantity) {

        while (!productQuantity.getAttribute("value").equals(expectedQuantity)){
            clickOnElement(arrowUpOnQuantity);
        }
        return this;
    }

    public boolean doesArrowUpUpdateQuantity(){
        int oldValue = Integer.parseInt(productQuantity.getAttribute("value"));
        clickOnElement(arrowUpOnQuantity);
        int newValue = Integer.parseInt(productQuantity.getAttribute("value"));
        if(oldValue < newValue){
            return true;
        }
        return false;
    }

    public boolean doesArrowDownUpdateQuantity(){
        int oldValue = Integer.parseInt(productQuantity.getAttribute("value"));
        clickOnElement(arrowDownOnQuantity);
        int newValue = oldValue - 1;
        if(oldValue - 1 == newValue){
            return true;
        }
        return false;
    }

    public BasketPage deleteProductAndCheckTheTotalPrice(){
        clickOnElement(deleteProduct);
        return this;
    }
}