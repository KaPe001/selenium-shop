package configuration.browserTask;

import configuration.browserTask.browserModels.YamlReader;

public class BrowserProperties {
    YamlReader yamlReader = new YamlReader();
    Browser browser;

    public BrowserProperties() {
    }

    public Browser getBrowser(){
        System.getProperty("browser");
        return findBrowser();

    }

    public Browser findBrowser() {
        switch (System.getProperty("browser")) {
            case "chrome":
                return Browser.CHROME;
            case "firefox":
                return Browser.FIREFOX;
            case "edge":
                return Browser.EDGE;
            default:
                return null;
        }
    }

//    public Browser findIfActive() {
//        browser = Browser.CHROME;
//        try {
//            browser = new YamlReader().getEnvironments().getEnvironmentType();
//        } catch (Exception e) {
//            System.out.println("No browser specified");
//            e.printStackTrace();
//        }
//        return browser;
//    }
}
