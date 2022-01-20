package configuration.browserTask;

import configuration.browserTask.browserModels.Environment;
import configuration.browserTask.yaml.YamlReader;

import java.util.logging.Logger;

public class ActiveEnvironment {
   private static YamlReader yr = new YamlReader();
    final static Logger logger = Logger.getLogger(String.valueOf(ActiveEnvironment.class));

    public static Environment getActiveEnv() {

        Environment env = yr.getEnvironments().stream()
                .filter(Environment::isActive)
                .findFirst().get();
        logger.info("Selected environment is: " + env.getEnvironmentType().toString());

        return env;
    }
}
