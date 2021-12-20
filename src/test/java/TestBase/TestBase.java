package TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    public WebDriver driver;
    public static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        logger.info("WebDriver set up correctly");
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://146.59.32.4/index.php");
        driver.manage().window().maximize();
        logger.info("Browser opened correctly");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info("Driver teared down correctly");
    }
}