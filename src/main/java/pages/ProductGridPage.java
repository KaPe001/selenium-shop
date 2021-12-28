package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductGridPage extends BasePage {
    String randomResult;

    @FindBy(css = ".product")
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

    public String getProductGridSizeLabel() {
        List<SingleProductGridPage> newProductGridList = createListOfProducts();
        if (newProductGridList.size() == 1) {
            return "There is 1 product.";
        }
        return "There are " + newProductGridList.size() + " products.";
    }

    public int getProductGridSize(){
        List<SingleProductGridPage> newProductGridList = createListOfProducts();
        return newProductGridList.size();
    }

    public WebElement getRandomWebElementFromList(List<WebElement> list) {
        int randomNumber = rnd.nextInt(list.size());
        return list.get(randomNumber);
    }

    public String getRandomProductName() {
        String getProductName = "";
        List<SingleProductGridPage> newList = createListOfProducts();
        for(SingleProductGridPage singleProductGridPage : newList) {
            getProductName = singleProductGridPage.getProductName();
        }
        return getProductName;
    }

    public ProductGridPage goToRandomProduct() {
        getRandomWebElementFromList(productList).click();
        return this;
    }

    public boolean isRegularPriceIsDisplayed() {
        for (SingleProductGridPage singleProduct : createListOfProducts()) {
            if (singleProduct.regularPrice.isDisplayed()) {
                return true;
            }
        }

        return false;
    }

    public boolean isPriceAfterDiscountPriceIsDisplayed() {
        for (SingleProductGridPage singleProduct : createListOfProducts()) {
            if (singleProduct.priceAfterDiscount.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean isDiscountFromProductsDisplayed() {
        for (SingleProductGridPage singleProductGridPage : createListOfProducts()) {
            if(singleProductGridPage.discount.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean calculateIfDiscountIsCorrect() {
        for (SingleProductGridPage singleProductGridPage : createListOfProducts()) {
            String regularPriceString = singleProductGridPage.getRegularPrice();
            regularPriceString = regularPriceString.replace("zł", " ");

            String priceAfterDiscountString = singleProductGridPage.getPriceAfterDiscount();
            priceAfterDiscountString = priceAfterDiscountString.replace("zł", " ");

            double regularPrice = Double.parseDouble(regularPriceString);
            double priceAfterDiscount = Double.parseDouble(priceAfterDiscountString);
            double actualPrice = regularPrice * 0.80d;
            if (actualPrice == priceAfterDiscount) {
                return true;
            }
        }
        return false;
    }

    public ProductGridPage openOneOfDiscountedProducts() {
        getRandomWebElementFromList(productList).click();
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
