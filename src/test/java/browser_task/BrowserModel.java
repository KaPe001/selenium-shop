package browser_task;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BrowserModel {

    private Browser browser;
    private String url;
    private boolean active;

    public Browser getBrowser() {
        return browser;
    }

    public String getUrl() {
        return url;
    }

    public boolean isActive() {
        return active;
    }

    public Map<String, String> getProperties(){
        Map<String, String> properties = new HashMap<>();
        properties.put("url", getUrl());
        return properties;
    }
}