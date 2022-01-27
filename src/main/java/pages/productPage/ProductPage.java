package pages.productPage;

import configuration.basket.BasketClass;
import configuration.basket.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

import java.math.BigDecimal;

public class ProductPage extends BasePage {

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

    @FindBy(css = ".modal-body .product-quantity strong")
    WebElement productQuantityInPopUp;

    @FindBy(css = ".modal-body .cart-products-count")
    WebElement productCountInPopUp;

    @FindBy(css = ".modal-body .subtotal")
    WebElement totalPrice;

    @FindBy(css = ".cart-content-btn .btn-secondary")
    WebElement continueShoppingBtn;

    @FindBy(css = ".cart-content > .cart-content-btn a")
    WebElement proceedToCheckoutBtn;

    @FindBy(css = "#_desktop_cart .cart-products-count")
    WebElement quantityOfCart;

    @FindBy(css = ".product-customization .card li textarea")
    WebElement sendMessage;

    @FindBy(css = ".product-customization .card .btn-primary")
    WebElement saveCustomization;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getRegularPrice(){
        return regularPrice.getText();
    }

    public String getPriceAfterDiscount(){
        return priceAfterDiscount.getText();
    }

    public BigDecimal getPriceAfterDiscountBigDecimal(){
        String priceAfterDiscountReplace = removeCurrency(priceAfterDiscount.getText());
        return new BigDecimal(priceAfterDiscountReplace);
    }

    public boolean isDiscountLabelDisplayed(){
        return discountLabel.isDisplayed();
    }

    public boolean isRegularPriceIsDisplayed(){
        return regularPrice.isDisplayed();
    }

    public boolean isPriceAfterDiscountIsDisplayed(){
        return priceAfterDiscount.isDisplayed();
    }

    public boolean isPriceAfterDiscountCorrect(String regularPriceString, String priceAfterDiscountString){
        regularPriceString = removeCurrency(regularPriceString);
        priceAfterDiscountString = removeCurrency(priceAfterDiscountString);

        double regularPrice = Double.parseDouble(regularPriceString);
        double priceAfterDiscount = Double.parseDouble(priceAfterDiscountString);

        double actualPrice = regularPrice * 0.80d;
        return actualPrice == priceAfterDiscount;
    }

    public ProductPage getRandomQuantityOfProducts(int min, int max){
        int quantity = rnd.nextInt(max - min + 1) + min;
        String quantityString = Integer.toString(quantity);
        sendKeysToElement(quantityInput, quantityString);
        return this;
    }

    public ProductPage addToCart(BasketClass basketClass){
        if(isCustomizeCardDisplayed()) {
            clickOnElement(sendMessage);
            sendKeysToElement(sendMessage, "hi!");
            clickOnElement(saveCustomization);
        }
        clickOnElement(addToCartBtn);
        basketClass.addProductToCart(new Product(getProductName(), getPriceAfterDiscountBigDecimal()), 1);
        return this;
    }

    public ProductPage addToCart(){
        if(isCustomizeCardDisplayed()) {
            clickOnElement(sendMessage);
            sendKeysToElement(sendMessage, "hi!");
            clickOnElement(saveCustomization);
        }
        waitUntil(addToCartBtn);
        clickOnElement(addToCartBtn);
        return this;
    }

    public String getProductCount(){
        return productCountInPopUp.getText();
    }

    public String checkIfCorrectProduct(){
        waitUntil(productNameInPopUp);
        return productNameInPopUp.getText();
    }

    public String getProductQuantity(){
        return productQuantityInPopUp.getText();
    }

    public String checkIfCorrectQuantity() {
        waitUntil(productQuantityInPopUp);
        return productQuantityInPopUp.getText();
    }

    public String checkIfProductCountIsCorrect(){
        return productCountInPopUp.getText();
    }

    public BigDecimal getTotalValue(){
        String totalPriceString = totalPrice.getText();
        totalPriceString = removeCurrency(totalPriceString);
        return new BigDecimal(totalPriceString);
    }

    public ProductPage continueShopping(){
        waitUntil(productNameInPopUp);
        clickOnElement(continueShoppingBtn);
        return this;
    }

    public ProductPage proceedToCheckout(){
        waitUntil(productNameInPopUp);
        clickOnElement(proceedToCheckoutBtn);
        return this;
    }

    public String getCartQuantity(){
        return quantityOfCart.getText();
    }

    public String checkIfUpdatedCartQuantity(){
        return quantityOfCart.getText();
    }

    public boolean isCustomizeCardDisplayed(){
        return productName.getText().equals("CUSTOMIZABLE MUG");
    }
}
