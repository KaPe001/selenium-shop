package configuration.browserTask;

import configuration.browserTask.browserModels.*;

import java.util.Objects;

public class Browsers {
    BrowserModel chrome;
    BrowserModel firefox;
    BrowserModel ie;
    BrowserModel edge;
    Browser browser;

    public BrowserModel getChrome() {
        return chrome;
    }

    public BrowserModel getFirefox() {
        return firefox;
    }

    public BrowserModel getIe() {
        return ie;
    }

    public BrowserModel getEdge() {
        return edge;
    }
    public Browser getBrowser(){
        Browser activeBrowser = null;
        if(Objects.equals(System.getProperty("active"), "true")){
            activeBrowser = browser;
        }
//        List<BrowserModel> browsers = new ArrayList<>();
//        browsers.add(getChrome());
//        browsers.add(getFirefox());
//        browsers.add(getIe());
//        browsers.add(getEdge());
        return activeBrowser;
    }
}
