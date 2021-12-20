package configuration.browserTask;

import configuration.BrowserModel;
import configuration.yaml.YamlReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public enum Browser {

    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("internet explorer"),
    EDGE("edge");

    public String browser;
    private BrowserModel browserEnvironment;

    Browser(String browserName) {
        this.browser = browserName;
    }

    public WebDriverManager getWebDriverManager() {
        switch (this) {
            case CHROME:
                return WebDriverManager.chromedriver();
            case FIREFOX:
                return WebDriverManager.firefoxdriver();
            case IE:
                return WebDriverManager.iedriver();
            case EDGE:
                return WebDriverManager.edgedriver();
        }
        return getWebDriverManager();
    }

//    public List<BrowserModel> getListOfBrowsers(){
//        List<BrowserModel> browsers = new ArrayList<>();
//        browsers.add(Browser.CHROME);
//        browsers.add(Browser.FIREFOX);
//        browsers.add(Browser.IE);
//        browsers.add(Browser.EDGE);
//
//        return browsers;
//    }

    public BrowserModel getTheBrowserAndFindUrl() {
        String findBrowser = new YamlReader().getConfigModel().getBrowser().browser;

        switch (findBrowser) {
            case "chrome":
                browser = CHROME.browser;
                break;
            case "firefox":
                browser = FIREFOX.browser;
                break;
            case "ie":
                browser = IE.browser;
                break;
            case "edge":
                browser = EDGE.browser;
                break;
        }
        return browserEnvironment;
    }
}
