package TestBase;

import configuration.browserTask.Browser;
import configuration.browserTask.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBaseForBrowserTask {

    private static DriverFactory driverFactory;
    private static Browser browser;
    public WebDriver driver;
    public static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    public static void setDriver() {
        driverFactory.getDriver(browser);
        logger.info("WebDriver set up correctly");
    }

    @BeforeEach
    public void setUp() {
        driver.get("http://146.59.32.4/index.php");
        logger.info("Browser opened correctly");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info("Driver teared down correctly");
    }
}
