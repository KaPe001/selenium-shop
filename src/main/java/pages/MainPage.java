package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {
    ProductGridPage productGridPage = new ProductGridPage(webDriver);

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

    public List<WebElement> createNewSubCategoryListDependingOnCategory(int index) {
        WebElement category = getCategoriesListIndex(index);
        return new SingleSubCategoryOnMainPage(category).getSubCategory();
    }

    public void goToArtCategory() {
        clickOnElement(art);
    }

    public void clickOnBanner() {
        clickOnElement(bannerPriceOff);
    }

    public void goToRandomCategory() {
        clickOnElement(productGridPage.getRandomWebElementFromList(categoriesList));
    }

    public void goToBasket(){
        clickOnElement(basketBtn);
    }
}