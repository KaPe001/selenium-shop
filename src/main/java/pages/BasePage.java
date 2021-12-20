package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Locale;
import java.util.Random;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    Random rnd = new Random();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());
    private Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(){
    }

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickOnElement (WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        logger.info("Element {} clicked", element.getText());
    }

    public void clickOnElementToSignUserOut(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void sendKeysToElement(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        logger.info("Send keys performed on element {}, message: {}", element.getAttribute("name"), text);
    }

    public void waitUntil(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
