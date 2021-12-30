package configuration;

import configuration.browserModels.Environment;
import configuration.browserTask.Browsers;
import lombok.Data;

@Data
public class ConfigModel {
    private Environment environment;
    private Browsers browsers;

}
