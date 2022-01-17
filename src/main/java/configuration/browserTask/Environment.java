package configuration.browserTask;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Environment {

    EnvironmentType environmentType;

    private String url;
    private String title;
    private String browser;
    private boolean isActive;
}
