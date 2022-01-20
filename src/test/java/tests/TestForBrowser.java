package tests;

import configuration.browserTask.ActiveEnvironment;
import configuration.browserTask.DriverFactory;
import configuration.browserTask.yaml.YamlReader;
import org.junit.jupiter.api.Test;
import testBase.TestBaseForBrowser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestForBrowser extends TestBaseForBrowser {
    YamlReader yr= new YamlReader();


    @Test
    public void openBrowser() {
        DriverFactory driverFactory = new DriverFactory();

        driver = driverFactory.getDriver(ActiveEnvironment.getActiveEnv().getBrowser());
        driver.get(ActiveEnvironment.getActiveEnv().getUrl());

        assertThat(driver.getTitle(), equalTo(ActiveEnvironment.getActiveEnv().getTitle()));
    }


    @Test
    public void printPropertiesFromYaml() {
        System.out.println(yr.getEnvironments().toString());
        assertTrue(true);
    }
}
