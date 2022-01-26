package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.WebListener;

@Slf4j
public class TestBase {
    public WebDriver webDriver;
    private EventFiringWebDriver driver;
    private WebListener webListener;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        log.info("WebDriver set up correctly");
    }

    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(webDriver);
        webListener = new WebListener();
        driver.register(webListener);
        driver.get("http://146.59.32.4/index.php");
        driver.manage().window().maximize();
        log.info("Browser opened correctly");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        log.info("Driver teared down correctly");
    }
}