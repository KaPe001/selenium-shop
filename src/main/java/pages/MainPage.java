package pages;

import org.junit.Assert;
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
    ProductGridPage productGridPage = new ProductGridPage(driver);
    Logger logger = LoggerFactory.getLogger(MainPage.class);

    private EventFiringMouse eventFiringMouse;
    private WebListener webListener;

    @FindBy(css = "[id='header'] [id='_desktop_user_info'] .hidden-sm-down")
    WebElement logInBtn;

    @FindBy(css = ".user-info span")
    WebElement userNameDisplayed;

    @FindBy(css = ".user-info .logout")
    WebElement logOutBtn;

    @FindBy(css = "#search_widget input[type='text']")
    WebElement searchBox;

    @FindBy(css = ".ui-menu-item span[class='product']")
    WebElement result;

    @FindBy(css = ".ui-menu .ui-menu-item")
    List<WebElement> resultList;

    @FindBy(css = "#top-menu > .category")
    List<WebElement> categoriesList;

    @FindBy(css = "#top-menu > .category > .sub-menu > .top-menu > .category")
    List<WebElement> subCategoriesList;

    @FindBy(css = "#category-3 > a")
    WebElement clothes;

    @FindBy(css = "#category-6 > a")
    WebElement accessories;

    @FindBy(css = "#category-9 > a")
    WebElement art;

    public MainPage mouseHoverOnElementFromList(WebElement element) {
        logger.info("Mouse hover on an element link from a list ");
        mouseHover(element);
        return this;
    }

    public MainPage mouseHoverClothes() {
        logger.info("Mouse hover on clothes link");
        mouseHover(clothes);
        return this;
    }

    public MainPage mouseHoverAccessories() {
        logger.info("Mouse hover on accessories link");
        mouseHover(accessories);
        return this;
    }

    public MainPage mouseHoverArt() {
        logger.info("Mouse hover on art link");
        mouseHover(art);
        return this;
    }

    private void mouseHover(WebElement webElement) {
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) webElement;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        clickOnElement(logInBtn);
    }

    public String verifyLoggedUserInfo() {
        System.out.println(userNameDisplayed.getText());
        return userNameDisplayed.getText();
    }

    public void logUserOut() {
        clickOnElementToSignUserOut(logOutBtn);
        if (userNameDisplayed.getText().equals("Sign in")) {
            System.out.println("User signed out properly");
        }
    }

    public MainPage searchProduct() {
        clickOnElement(searchBox);
        sendKeysToElement(searchBox, productGridPage.getRandomProduct());
        return this;
    }

    public String getResultName() {
        return searchBox.getText();
    }

    public MainPage selectResult() {
        clickOnElement(result);
        return this;
    }

    public MainPage checkForResultInResultDropDownList() {
        for (int i = 1; i <= resultList.size(); i++) {
            if (result.equals(productGridPage.randomResult)) {
                System.out.println("Products match");
            } else {
                System.out.println("Something went wrong");
            }
        }
        return this;
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

    public MainPage iterateThroughAllCategories() {
        CategoryPage categoryPage = new CategoryPage(driver);

        for (int i = 0; i < createNewCategoryList().size(); i++) {
            clickOnElement(categoriesList.get(i));

            waitUntil(categoryPage.categoryName);
            assertThat(categoryPage.getCategoryName(), equalTo(driver.findElement(By.cssSelector("#js-product-list-header h1")).getText()));
            logger.info("Category name matches with clicked category");

            categoryPage.checkIfFilterMenuIsDisplayed();
            logger.info("Filters are displayed");

            Assert.assertEquals(categoryPage.printHowManyProducts(), (getActualProductGridSize(productGridPage.createListOfProducts().size())));
            logger.info("Amount of products in grid match with the label");
        }
        return this;
    }

    public MainPage iterateThroughSubCategories() {
        CategoryPage categoryPage = new CategoryPage(driver);

        for (int i = 0; i < createNewCategoryList().size(); i++) {
            System.out.println(createNewCategoryList().size());
            mouseHoverOnElementFromList(categoriesList.get(i));

            for(int j = 0; j < createNewSubCategoryList().size() - 2; j++){
                System.out.println(createNewSubCategoryList().size());
                clickOnElement(subCategoriesList.get(j));
                waitUntil(categoryPage.categoryName);
                assertThat(categoryPage.getCategoryName(), equalTo(driver.findElement(By.cssSelector("#js-product-list-header h1")).getText()));
                logger.info("Category name matches with clicked category");

                categoryPage.checkIfFilterMenuIsDisplayed();
                logger.info("Filters are displayed");

                Assert.assertEquals(categoryPage.printHowManyProducts(), (getActualProductGridSize(productGridPage.createListOfProducts().size())));
                mouseHoverOnElementFromList(categoriesList.get(i));
            }
        }
        return this;
    }

    public String getActualProductGridSize(int size) {
        ProductGridPage productGridPage = new ProductGridPage(driver);
        if (productGridPage.createListOfProducts().size() == 1) {
            return "There is 1 product.";
        }
        return "There are " + size + " products.";
    }
}
