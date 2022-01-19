package pages;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class BasePage {

    public WebDriver webDriver;
    public FluentWait<WebDriver> wait;
    Random rnd = new Random();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public Logger logger = LoggerFactory.getLogger(BasePage.class);
    WebDriverEventListener webListener;

    public BasePage() {
    }

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickRadioButton(WebElement element) {
        element.click();
    }

    public void clickOnElementToSignUserOut(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void sendKeysToElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        logger.info("Send keys performed on element {}, message: {}", element.getAttribute("name"), text);
    }

    public void waitUntil(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementValue(WebElement element, String initialValue) {
        wait.until((ExpectedCondition<Boolean>) webDriver -> !Objects.equals(element.getText(), initialValue));
    }

    public void logMessage(String text) {
        logger.info(text);
    }

    public boolean retryOnStaleElement(WebElement element) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                element.getAttribute("value");
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            attempts++;
        }
        return result;
    }

    public static String removeCurrency(String string) {
        return string.replace("$", "");
    }
}
