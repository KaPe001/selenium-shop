package configuration.yaml;

import configuration.ConfigModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class YamlReader {

    private ConfigModel configModel;

    public ConfigModel getConfigModel(){
        return configModel;
    }

    public YamlReader(){

        try{
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.configModel = mapper.readValue(new File("src/main/resources/config-local.yaml"), ConfigModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
