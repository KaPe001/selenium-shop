package configuration.browserTask;

public class BaseYamlReader {

    public String setCurrentBrowserUrl() {
        String url = null;
        url = System.getProperty("url");
        return url;
    }
}
