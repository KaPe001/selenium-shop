package pages.basketPage;

import configuration.basket.BasketClass;
import configuration.basket.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(css = ".cart-overview li")
    List<WebElement> listOfProductsInBasket;

    @FindBy(css = ".cart-detailed-totals  .card-block .cart-total .value")
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
            for (Product product : basketClass.getBasketProducts().keySet()) {
                if (product.getName().equals(basketProductPage.getProductName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public BasketPage proceedToCheckout() {
        clickOnElement(checkOutBtn);
        return this;
    }

    public BigDecimal getTotalPriceFromWebSite(){
        BigDecimal totalPrice = new BigDecimal(removeCurrency(productTotalPrice.getText()));
        System.out.println(totalPrice);
        return totalPrice;
    }

    public Product getSingleProduct() {
        Product product = new Product("", BigDecimal.valueOf(0.00));
        List<BasketProductPage> listOfProductsInBasket = createNewProductsList();
        for (BasketProductPage basketProductPage : listOfProductsInBasket) {
            BigDecimal productPrice = new BigDecimal(basketProductPage.getProductTotalPrice());
            product = new Product(basketProductPage.getProductName(), productPrice);
        }
        return product;
    }

    public int getProductsQuantity(){
        return Integer.parseInt(productQuantity.getAttribute("value"));
    }

    public BasketPage increaseQuantity(String expectedQuantity, BasketClass basketClass) {
        basketClass.increaseQuantityByExpectedQuantity(getSingleProduct(), getProductsQuantity(), Integer.parseInt(expectedQuantity));
        String initialValue = totalItems.getText();
        while (!productQuantity.getAttribute("value").equals(expectedQuantity)) {
            clickOnElement(arrowUpOnQuantity);
            waitForElementValue(totalItems, initialValue);
        }
        return this;
    }

    public boolean doesArrowUpUpdateQuantity(BasketClass basketClass) {
        int oldValue = Integer.parseInt(productQuantity.getAttribute("value"));
        String initialValue = totalItems.getText();
        clickOnElement(arrowUpOnQuantity);
        waitForElementValue(totalItems, initialValue);
        int newValue = Integer.parseInt(productQuantity.getAttribute("value"));
        if (oldValue < newValue) {
            return true;
        }
        basketClass.increaseQuantityByOne(getSingleProduct(), getProductsQuantity());
        return false;
    }

    public boolean doesArrowDownUpdateQuantity(BasketClass basketClass) {
        int oldValue = Integer.parseInt(productQuantity.getAttribute("value"));
        String initialValue = totalItems.getText();
        clickOnElement(arrowDownOnQuantity);
        waitForElementValue(totalItems, initialValue);
        basketClass.decreaseQuantityByOne(getSingleProduct(), getProductsQuantity());
        int newValue = oldValue - 1;
        return oldValue - 1 == newValue;
    }

    public BasketPage deleteProduct(BasketClass basketClass) {
        String initialValue = totalItems.getText();
        clickOnElement(deleteProduct);
        basketClass.decreaseQuantityByOne(getSingleProduct(), getProductsQuantity());
        waitForElementValue(totalItems, initialValue);
        return this;
    }
}