package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductGridPage extends BasePage {
    String randomResult;

    @FindBy(css = ".product .product-title")
    List<WebElement> productList;

    public ProductGridPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<SingleProductGridPage> createListOfProducts() {
        List<SingleProductGridPage> newList = new ArrayList<>();
        for (WebElement element : productList) {
            newList.add(new SingleProductGridPage(element));
        }
        return newList;
    }

    public WebElement getRandomWebElementFromList(List<WebElement> list) {
        int randomNumber = rnd.nextInt(list.size());
        return list.get(randomNumber);
    }

    public String getRandomProductName() {
        return getRandomWebElementFromList(productList).getText();
    }

    public ProductGridPage goToRandomProduct() {
        getRandomWebElementFromList(productList).click();

//        productPage.isCustomizeCardDisplayed();
        return this;
    }

    public ProductGridPage checkIfRegularPriceIsDisplayed() {
        for (SingleProductGridPage singleProduct : createListOfProducts()) {
            if (!singleProduct.regularPrice.isDisplayed()) {
                logMessage("Something went wrong, regular price is not displayed!");
            }
        }

        return this;
    }

    public ProductGridPage checkIfPriceAfterDiscountPriceIsDisplayed() {
        for (SingleProductGridPage singleProduct : createListOfProducts()) {
            if (!singleProduct.priceAfterDiscount.isDisplayed()) {
                logMessage("Something went wrong, regular price is not displayed!");
            }
        }
        return this;
    }

    public String getDiscountFromProducts() {
        String discountText = "";
        for (SingleProductGridPage singleProductGridPage : createListOfProducts()) {
            discountText = singleProductGridPage.getDiscount();
        }
        return discountText;
    }

    public String getPriceAfterDiscount() {
        String priceAfterDiscount = "";
        for (SingleProductGridPage singleProductGridPage : createListOfProducts()) {
            singleProductGridPage.getPriceAfterDiscount();
        }
        return priceAfterDiscount;
    }

    public String getRegularPrice(){
        String regularPrice = "";
        for(SingleProductGridPage singleProductGridPage : createListOfProducts()) {
            singleProductGridPage.getRegularPrice();
        }
        return regularPrice;
    }

    public ProductGridPage calculateIfDiscountIsCorrect(String regularPriceString, String priceAfterDiscount) {
        for (SingleProductGridPage singleProductGridPage : createListOfProducts()){
            regularPriceString = singleProductGridPage.getRegularPrice();
            regularPriceString = regularPriceString.replace("zł"," ");

            double regularPrice = Double.parseDouble(regularPriceString);
            double actualPrice = regularPrice * 0.80d;
            logMessage("Actual price is: " + String.format("%.2f", actualPrice) +
                    " The product price on a website is: " + singleProductGridPage.getPriceAfterDiscount());
    }
        return this;
    }

    public ProductGridPage openOneOfDiscountedProducts() {
        for (SingleProductGridPage singleProductGridPage : createListOfProducts()) {
            singleProductGridPage.clickOnProduct();
        }
        return this;
    }

    public boolean isProductOnTheList(String productName){
        List<SingleProductGridPage> productsList = createListOfProducts();
        for(SingleProductGridPage singleProductGridPage : productsList){
            waitUntil(singleProductGridPage.singleProductFromGrid);
            if(singleProductGridPage.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }
}
