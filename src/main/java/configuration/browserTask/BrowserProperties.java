package configuration.browserTask;
import configuration.browserTask.yaml.*;

public class BrowserProperties {
    YamlReader yamlReader = new YamlReader();

    public BrowserProperties(){

    }
    public Browser getBrowser(){
        Browser browser = null;
        try{
            browser = yamlReader.getConfig().getBrowsers().getBrowser();
        } catch (Exception e) {
            e.printStackTrace();
            return browser;
        }
        return browser;
    }
}
