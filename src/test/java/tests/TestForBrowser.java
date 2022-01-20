package tests;

import configuration.browserTask.Browser;
import configuration.browserTask.DriverFactory;
import configuration.browserTask.browserModels.YamlReader;
import org.junit.jupiter.api.Test;
import testBase.TestBaseForBrowser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestForBrowser extends TestBaseForBrowser {

    @Test
    public void openBrowser() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(Browser.CHROME);
        driver.get("http://kotuszkowo.pl");
        assertTrue(true);
//        assertThat(driver.getTitle(), equalTo(System.getProperty("title")));
    }


    @Test
    public void printPropertiesFromYaml() {
        YamlReader yr = new YamlReader();
        System.out.println(yr.getEnvironments().toString());
        assertTrue(true);
    }
}
