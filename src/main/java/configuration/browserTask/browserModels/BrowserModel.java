package configuration.browserTask.browserModels;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BrowserModel {
    private boolean active;
    Environment environments;
    Map<String,Object> properties = new HashMap<>();

    public boolean isActive() {
        return active;
    }

    @JsonAnySetter
    void setProperties(String key, Object value){
        properties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getProperties(){
        return properties;
    }
}