package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainPage extends BasePage {
    ProductGridPage productGridPage = new ProductGridPage(webDriver);
    Logger logger = LoggerFactory.getLogger(MainPage.class);

    private WebListener webListener;

    @FindBy(css = "[id='header'] [id='_desktop_user_info'] .hidden-sm-down")
    WebElement logInBtn;

    @FindBy(css = ".user-info span")
    WebElement userNameDisplayed;

    @FindBy(css = ".user-info .logout")
    WebElement logOutBtn;

    @FindBy(css = "#search_widget input[type='text']")
    WebElement searchBox;

    @FindBy(css = "#search_widget .material-icons")
    WebElement searchIcon;

    @FindBy(css = ".ui-menu")
    List<WebElement> resultList;

    @FindBy(css = "#top-menu > .category")
    List<WebElement> categoriesList;

    @FindBy(css = "#top-menu > .category > .sub-menu > .top-menu > .category")
    List<WebElement> subCategoriesList;

    @FindBy(css = "#category-9 > a")
    WebElement art;

    @FindBy(css = "#footer #link-product-page-prices-drop-1")
    WebElement bannerPriceOff;

    @FindBy(css = "#_desktop_cart a")
    WebElement basketBtn;

    public void mouseHoverOnElementFromList(WebElement element) {
        logger.info("Mouse hover on an element link from a list ");
        mouseHover(element);
    }

    private void mouseHover(WebElement webElement) {
        EventFiringMouse eventFiringMouse = new EventFiringMouse(webDriver, webListener);
        Locatable item = (Locatable) webElement;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
    }

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToLoginPage() {
        clickOnElement(logInBtn);
    }

    public String verifyLoggedUserInfo() {
        return userNameDisplayed.getText();
    }

    public void logUserOut() {
        clickOnElementToSignUserOut(logOutBtn);
        if (userNameDisplayed.getText().equals("Sign in")) {
            logMessage("User signed out properly");
        }
    }

    public MainPage searchProduct(String productName) {
        sendKeysToElement(searchBox, productName);

        return this;
    }

    public MainPage clickSearchIcon(){
        clickOnElement(searchIcon);
        return this;
    }

    public List<SingleDropdownResultList> getNewResultList(){
        List<SingleDropdownResultList> newResultList = new ArrayList<>();
        for(WebElement element : resultList) {
            newResultList.add(new SingleDropdownResultList(element));
        }
        return newResultList;
    }

    public String printListProducts() {
        String printResult = "";
        List<SingleDropdownResultList> dropdownList = getNewResultList();
        for (SingleDropdownResultList singleDropdownResultList : dropdownList) {
            printResult = singleDropdownResultList.getResultFromListName();
        }
        return printResult;
    }

    public boolean isResultInResultDropDownList(String randomResult) {
        List<SingleDropdownResultList> dropdownList = getNewResultList();
        for (SingleDropdownResultList singleDropdownResultList : dropdownList) {
            waitUntil(singleDropdownResultList.result);
            if (singleDropdownResultList.getResultFromListName().equals(randomResult)) {
                return true;
            }
        }
        return false;
    }

    public WebElement getCategoriesListIndex(int index){
        return categoriesList.get(index);
    }

    public List<SingleCategoryOnMainPage> createNewCategoryList() {
        List<SingleCategoryOnMainPage> newCategoryList = new ArrayList<>();
        for (WebElement element : categoriesList) {
            newCategoryList.add(new SingleCategoryOnMainPage(element));
        }
        return newCategoryList;
    }

    public List<SingleSubCategoryOnMainPage> createNewSubCategoryList() {
        List<SingleSubCategoryOnMainPage> newSubCategoryList = new ArrayList<>();
        for (WebElement element : subCategoriesList) {
            newSubCategoryList.add(new SingleSubCategoryOnMainPage(element));
        }
        return newSubCategoryList;
    }

//    public MainPage iterateThroughAllCategories() {
//        CategoryPage categoryPage = new CategoryPage(webDriver);
//
//        for (int i = 0; i < createNewCategoryList().size(); i++) {
//            clickOnElement(categoriesList.get(i));
//
//            waitUntil(categoryPage.categoryName);
//            assertThat(categoryPage.getCategoryName(), equalTo(webDriver.findElement(By.cssSelector("#js-product-list-header h1")).getText()));
//            logMessage("Category name matches with clicked category");
//
//            categoryPage.checkIfFilterMenuIsDisplayed();
//            logMessage("Filters are displayed");
//
//            Assert.assertEquals(categoryPage.printHowManyProducts(), (getActualProductGridSize(productGridPage.createListOfProducts().size())));
//            logMessage("Amount of products in grid match with the label");
//        }
//        return this;
//    }

    public void iterateThroughSubCategories() {
        CategoryPage categoryPage = new CategoryPage(webDriver);

        for (int i = 0; i < createNewCategoryList().size(); i++) {
            mouseHoverOnElementFromList(categoriesList.get(i));

            for (int j = 0; j < createNewSubCategoryList().size() - 2; j++) {
                clickOnElement(subCategoriesList.get(j));
                waitUntil(categoryPage.categoryName);
                assertThat(categoryPage.getCategoryName(), equalTo(webDriver.findElement(By.cssSelector("#js-product-list-header h1")).getText()));
                logMessage("Category name matches with clicked category");

                categoryPage.checkIfFilterMenuIsDisplayed();
                logMessage("Filters are displayed");

//                Assert.assertEquals(categoryPage.printHowManyProducts(), (getActualProductGridSize(productGridPage.createListOfProducts().size())));
                mouseHoverOnElementFromList(categoriesList.get(i));
            }
        }
    }

    public String getActualProductGridSize(int size) {
        if (productGridPage.createListOfProducts().size() == 1) {
            return "There is 1 product.";
        }
        return "There are " + size + " products.";
    }

    public void goToArtCategory() {
        clickOnElement(art);
    }

    public void clickOnBanner() {
        clickOnElement(bannerPriceOff);
    }

    public void goToRandomCategory() {
        productGridPage.getRandomWebElementFromList(categoriesList).click();
    }

    public void goToBasket(){
        clickOnElement(basketBtn);
    }
}