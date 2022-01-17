package configuration.browserTask.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.browserTask.Environment;

import java.io.File;

public class YamlReader {
    private Environment environments;

    public Environment getEnvironments() {
        return environments;
    }

    public YamlReader() {
        try{
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.environments = mapper.readValue(new File("src/main/resources/config-local.yaml"), Environment.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
