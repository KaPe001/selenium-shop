package configuration.browserTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    WebDriver driver;

    public WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                break;
            case FIREFOX:
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.chromedriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                break;
            case EDGE:
                EdgeOptions edgeOption= new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                edgeOption.addArguments("start-maximized");
                driver = new EdgeDriver(edgeOption);
            default:
                WebDriverManager.iedriver().setup();
        }
        return this.driver;
    }
}
