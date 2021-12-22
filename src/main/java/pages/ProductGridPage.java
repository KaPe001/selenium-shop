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

    public String getRandomProduct() {
        for (SingleProductGridPage singleProduct : createListOfProducts()) {
            int randomProduct = rnd.nextInt(createListOfProducts().size());
            randomResult = createListOfProducts().get(randomProduct).getProductName();
        }
        return randomResult;
    }

    public ProductGridPage checkIfRegularPriceIsDisplayed() {
        for (SingleProductGridPage singleProduct : createListOfProducts()) {
            if (!singleProduct.regularPrice.isDisplayed()) {
//                System.out.println("Something went wrong, regular price is not displayed!");
                logMessage("Something went wrong, regular price is not displayed!");
            }
        }

        return this;
    }

    public ProductGridPage checkIfPriceAfterDiscountPriceIsDisplayed() {
        for (SingleProductGridPage singleProduct : createListOfProducts()) {
            if (!singleProduct.priceAfterDiscount.isDisplayed()) {
//                System.out.println("Something went wrong, regular price is not displayed!");
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
            System.out.println("Actual price is: " + String.format("%.2f", actualPrice) +
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
}
