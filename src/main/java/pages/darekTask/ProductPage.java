package pages.darekTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = ".product-container [itemprop = 'name']")
    WebElement productName;

    @FindBy(css = ".product-quantity [name='qty']")
    WebElement quantityInput;

    @FindBy(css = ".add .btn-primary")
    WebElement addToCartBtn;

    @FindBy(css = ".modal-content .modal-header h4")
    WebElement popUpTitle;

    @FindBy(css = ".cart-content > .cart-content-btn a")
    WebElement proceedToCheckoutBtn;

    @FindBy(css = ".product-customization .card li textarea")
    WebElement sendMessage;

    @FindBy(css = ".product-customization .card .btn-primary")
    WebElement saveCustomization;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductPage addToCart(){
        if(isCustomizeCardDisplayed()) {
            clickOnElement(sendMessage);
            sendKeysToElement(sendMessage, "hi!");
            clickOnElement(saveCustomization);
        }
        waitUntil(productName);
//        clickOnElement(addToCartBtn);
        clickRadioButton(addToCartBtn);
        return this;
    }

    public ProductPage proceedToCheckout(){
        if(!popUpTitle.isDisplayed()) {
            waitUntil(popUpTitle);
        }
        clickOnElement(proceedToCheckoutBtn);
        return this;
    }

    public ProductPage getQuantity(String quantity){
        sendKeysToElement(quantityInput, quantity);
        return this;
    }

    public boolean isCustomizeCardDisplayed(){
        if(productName.getText().equals("CUSTOMIZABLE MUG")){
            return true;
        }
        return false;
    }
}
