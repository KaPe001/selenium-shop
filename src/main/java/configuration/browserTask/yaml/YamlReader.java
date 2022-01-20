package configuration.browserTask.yaml;

import configuration.browserTask.browserModels.Environment;
import configuration.browserTask.browserModels.EnvironmentConfig;
import configuration.browserTask.browserModels.User;
import configuration.browserTask.browserModels.UserConfig;
import lombok.Getter;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.util.List;

@Getter
public class YamlReader {
    private List<Environment> environments;
    private List<User> users;


    public YamlReader() {
        try{
            Yaml yaml = new Yaml(new Constructor(EnvironmentConfig.class));
            EnvironmentConfig config = yaml.load(new FileInputStream("src/main/resources/config-local.yaml"));
            this.environments = config.getEnvironments();

            Yaml yamlUsers = new Yaml(new Constructor(UserConfig.class));
            UserConfig userConfig = yamlUsers.load(new FileInputStream("src/main/resources/configUser.yaml"));
            this.users = userConfig.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
