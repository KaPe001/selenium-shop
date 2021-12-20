package browser_task;

import yaml.YamlReader;

import java.util.List;

public class BaseYamlReader {
    private YamlReader yamlReader;
//    List<BrowserModel> browsersList;
    Browsers browsers;


    public String setCurrentBrowser(){
        String url = null;
        url = getActiveObject().getUrl();
        return url;
    }

    public BrowserModel getActiveObject(){
        BrowserModel be = null;
        yamlReader = new YamlReader();
//        browsersList = yamlReader.getConfigModel().getBrowser().getListOfBrowsers();

        browsers.getChrome().getTheBrowserAndFindUrl().getUrl();
        browsers.getFirefox().getTheBrowserAndFindUrl().getUrl();
        browsers.getIe().getTheBrowserAndFindUrl().getUrl();
        browsers.getEdge().getTheBrowserAndFindUrl().getUrl();

//        for(BrowserModel singleBrowser : browsersList){
//            if(singleBrowser.isActive()){
//                be = singleBrowser;
//                break;
//            }
//        }
        return be;
    }

}
