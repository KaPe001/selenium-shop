package configuration.browserTask.browserModels;

import lombok.Getter;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.util.List;

@Getter
public class YamlReader {
    private List<Environment> environments;

    public YamlReader() {
        try{
            Yaml yaml = new Yaml(new Constructor(EnvironmentConfig.class));
            EnvironmentConfig config = yaml.load(new FileInputStream("src/main/resources/config-local.yaml"));
            this.environments = config.getEnvironments();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
