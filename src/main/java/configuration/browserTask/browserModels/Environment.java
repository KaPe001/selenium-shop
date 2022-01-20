package configuration.browserTask.browserModels;

import configuration.browserTask.EnvironmentType;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Environment {

    EnvironmentType environmentType;

    private String url;
    private String title;
    private String browser;
    private boolean isActive;
}
