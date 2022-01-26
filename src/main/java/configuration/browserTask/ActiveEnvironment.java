package configuration.browserTask;

import configuration.browserTask.browserModels.Environment;
import configuration.browserTask.yaml.YamlReader;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ActiveEnvironment {
   private static YamlReader yr = new YamlReader();

    public static Environment getActiveEnv() {

        Environment env = yr.getEnvironments().stream()
                .filter(Environment::isActive)
                .findFirst().get();
        log.info("Selected environment is: " + env.getEnvironmentType().toString());

        return env;
    }
}
