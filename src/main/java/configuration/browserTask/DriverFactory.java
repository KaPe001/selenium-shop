package configuration.browserTask;

import configuration.BrowserModel;
import configuration.yaml.YamlReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;


public class DriverFactory extends BaseYamlReader {
    WebDriver driver;
    YamlReader yr;

    BrowserModel browserModel;

    public WebDriver getDriver(Browser browser) {

        switch (browserModel.getBrowser()) {
            case CHROME:
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                String url = yr.getConfigModel().getBrowser().getTheBrowserAndFindUrl().getUrl();
                System.out.println(url);
                break;
            case FIREFOX:
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.chromedriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                String url1 = yr.getConfigModel().getBrowser().getTheBrowserAndFindUrl().getUrl();
                System.out.println(url1);
                break;
            case IE:
                InternetExplorerOptions optionsInternetExplorer = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                optionsInternetExplorer.addCommandSwitches("start-maximized");
                driver = new InternetExplorerDriver(optionsInternetExplorer);
                String url2 = yr.getConfigModel().getBrowser().getTheBrowserAndFindUrl().getUrl();
                System.out.println(url2);
                break;
            case EDGE:
                EdgeOptions optionsEdge = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                optionsEdge.addArguments("start-maximized");
                driver = new EdgeDriver(optionsEdge);
                String url3 = yr.getConfigModel().getBrowser().getTheBrowserAndFindUrl().getUrl();
                System.out.println(url3);
                break;
        }
        return this.driver;
    }
}
