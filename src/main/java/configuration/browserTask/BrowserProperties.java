package configuration.browserTask;

import configuration.browserTask.yaml.YamlReader;

public class BrowserProperties {
    YamlReader yamlReader = new YamlReader();

    public BrowserProperties() {
    }

//    public String getBrowser(){
//        Browser browser = null;
//        try{
////            browser = yamlReader.getEnvironment().getBrowser();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        return browser;
////    }
}
