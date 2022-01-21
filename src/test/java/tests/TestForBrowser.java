package tests;

import configuration.browserTask.ActiveEnvironment;
import configuration.browserTask.DriverFactory;
import configuration.browserTask.yaml.YamlReader;
import org.junit.jupiter.api.Test;
import testBase.TestBaseForBrowser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestForBrowser extends TestBaseForBrowser {

    @Test
    public void openBrowser() {
        DriverFactory driverFactory = new DriverFactory();

        driver = driverFactory.getDriver(ActiveEnvironment.getActiveEnv().getBrowser());
        driver.get(ActiveEnvironment.getActiveEnv().getUrl());

        assertThat(driver.getTitle(), equalTo(ActiveEnvironment.getActiveEnv().getTitle()));
    }
}
