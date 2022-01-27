package pages.basePage;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

@Slf4j
public class BasePage {

    public WebDriver webDriver;
    public FluentWait<WebDriver> wait;
    protected Random rnd = new Random();
    protected FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    protected WebDriverEventListener webListener;

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

    public <T> T getRandomElement(List<T> list) {
        return list.get(rnd.nextInt(list.size()));
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Perform click on element: {}" , element.getText());
        element.click();
    }

    public void clickRadioButton(WebElement element) {
        element.click();
    }

    public void clickOnElementToSignUserOut(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element {} , to be clicked", element.getText());
        element.click();
    }

    public void sendKeysToElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        log.info("Send keys performed on element {}, message: {}", element.getAttribute("name"), text);
    }

    public void waitUntil(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementValue(WebElement element, String initialValue) {
        wait.until((ExpectedCondition<Boolean>) webDriver -> !Objects.equals(element.getText(), initialValue));
    }

    public void logMessage(String text) {
        log.info(text);
    }

    public static String removeCurrency(String string) {
        return string.replace("$", "");
    }
}
