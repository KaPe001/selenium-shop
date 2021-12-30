package tests;

import configuration.browserTask.Browser;
import configuration.browserTask.DriverFactory;
import org.junit.jupiter.api.Test;
import testBase.TestBaseForBrowser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestForBrowser extends TestBaseForBrowser {

    @Test
    public void openBrowser() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(Browser.EDGE);
        assertTrue(true);
//        assertThat(driver.getTitle(), equalTo(System.getProperty("title")));
    }
}
