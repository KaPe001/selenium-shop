package testBase;

import configuration.browserTask.BrowserProperties;
import configuration.browserTask.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TestBaseForBrowser {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    public static WebDriver driver;
    public static BrowserProperties browserProperties;
    public static DriverFactory driverFactory;

    @BeforeAll
    static void setUp() throws IOException {
        browserProperties = new BrowserProperties();
        logger.info("WebDriver initialized");
    }

    @BeforeEach
    void beforeEach()  {
        driverFactory = new DriverFactory();
        logger.debug("Driver initialized");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.debug("Driver closed");
    }
}
