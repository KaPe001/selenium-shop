package pages.darekTask;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {

    public WebDriver webDriver;
//    public FluentWait<WebDriver> wait;
    private Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
    }

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
//        wait = new FluentWait<WebDriver>(webDriver)
//                        .withTimeout(Duration.ofSeconds(40))
//                        .pollingEvery(Duration.ofSeconds(5))
//                        .ignoring(NoSuchElementException.class);
    }

//    public void clickOnElement(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        element.click();
//    }
//
//    public void clickRadioButton(WebElement element){
//        element.click();
//    }

    public boolean retryOnStaleElement(WebElement element){
        boolean result = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                element.click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

//    public void clickOnElementToSignUserOut(WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//        element.click();
//    }
//
//    public void sendKeysToElement(WebElement element, String text) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//        element.clear();
//        element.sendKeys(text);
//        logger.info("Send keys performed on element {}, message: {}", element.getAttribute("name"), text);
//    }
//
//    public void waitUntil(WebElement webElement) {
//        wait.until(ExpectedConditions.visibilityOf(webElement));
//    }
//
//    public void logMessage(String text) {
//        logger.info(text);
//    }
}
