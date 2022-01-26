package configuration.browserTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@Slf4j
public class DriverFactory {

    public WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFireFoxDriver();
            case EDGE:
                return getEdgeDriver();
            default:
                log.info("Wrong driver selected");
        }
        return null;
    }

    private WebDriver getEdgeDriver() {
        EdgeOptions edgeOption= new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        edgeOption.addArguments("start-maximized");
        return new EdgeDriver(edgeOption);
    }

    private WebDriver getFireFoxDriver() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        WebDriverManager.chromedriver().setup();
        optionsFirefox.addArguments("start-maximized");
        return new FirefoxDriver(optionsFirefox);
    }

    private WebDriver getChromeDriver() {
        ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        return new ChromeDriver(optionsChrome);
    }
}
