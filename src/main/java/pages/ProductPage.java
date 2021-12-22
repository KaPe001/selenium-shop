package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProductPage extends BasePage {
    ProductGridPage productGridPage = new ProductGridPage(webDriver);

    @FindBy(css = ".product-container [itemprop = 'name']")
    WebElement productName;

    @FindBy(css = ".current-price .discount")
    WebElement discountLabel;

    @FindBy(css = ".product-prices .regular-price")
    WebElement regularPrice;

    @FindBy(css = ".product-prices .current-price span")
    WebElement priceAfterDiscount;

    @FindBy(css = ".product-quantity [name='qty']")
    WebElement quantityInput;

    @FindBy(css = ".add .btn-primary")
    WebElement addToCartBtn;

    @FindBy(css = ".modal-body .product-name")
    WebElement productNameInPopUp;

    @FindBy(css = ".modal-body .product-quantity")
    WebElement productQuantityInPopUp;

    @FindBy(css = ".modal-body .cart-products-count")
    WebElement productCountInPopUp;

    @FindBy(css = ".modal-body .product-price")
    WebElement productPriceInPopUp;

    @FindBy(css = ".modal-body .subtotal")
    WebElement totalPrice;

    @FindBy(css = ".cart-content-btn .btn-secondary")
    WebElement continueShoppingBtn;

    @FindBy(css = "#_desktop_cart .cart-products-count")
    WebElement quantityOfCart;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductName() {
        return productName.getText();
    }

    public ProductPage checkForLabel(){
        discountLabel.getText();
        return this;
    }

    public ProductPage checkIfRegularPriceIsDisplayed(){
        if(!regularPrice.isDisplayed()){
            logMessage("Something went wrong, price isn't displayed");
        }
        return this;
    }

    public ProductPage checkIfPriceAfterDiscountIsDisplayed(){
        if(!priceAfterDiscount.isDisplayed()){
            logMessage("Something went wrong, price isn't displayed");
        }
        return this;
    }

    public ProductPage calculateDiscount() {
        productGridPage.calculateIfDiscountIsCorrect(regularPrice.getText(), priceAfterDiscount.getText());
        logMessage("Regular price on ProductPage is: 44.16, price after discount is: " + priceAfterDiscount.getText()
                + " which is - 20% on a regular price");
        return this;
    }

    public ProductPage getRandomQuantityOfProducts(){
        int min = 1;
        int max = 5;
        int quantity = rnd.nextInt(max - min + 1) + min;
        String quantityString = Integer.toString(quantity);
        sendKeysToElement(quantityInput, quantityString);
        return this;
    }

    public ProductPage addToCart(){
        clickOnElement(addToCartBtn);
        return this;
    }

    public String checkIfCorrectProduct(){
        waitUntil(productNameInPopUp);
        return productNameInPopUp.getText();
    }

    public String checkIfCorrectQuantity() {
        waitUntil(productQuantityInPopUp);
        return productQuantityInPopUp.getText();
    }

    public String checkIfProductCountIsCorrect(){
        return productCountInPopUp.getText();
    }

    public String getSubtotalValueConvert(){
        String totalPriceString = totalPrice.getText();
        totalPriceString = totalPriceString.replace("zł","");
        return totalPriceString;
    }

    public String checkIfTotalProductPriceIsCorrect(){
        String productPrice = productPriceInPopUp.getText();
        String quantity = productQuantityInPopUp.getText();
        productPrice = productPrice.replace("zł","");
        quantity = quantity.replace("Quantity: ","");
        getSubtotalValueConvert();

        double subtotal = Double.parseDouble(productPrice) * Integer.parseInt(quantity);
        String.format("%.2f", subtotal);
        String subtotalString = Double.toString(subtotal);
        subtotalString = subtotalString.replace("<>","");

        return subtotalString;
    }

    public ProductPage continueShopping(){
        clickOnElement(continueShoppingBtn);
        return this;
    }

    public String checkIfUpdatedCartQuantity(){
        return quantityOfCart.getText();
    }
}
