package configuration.browserTask.browserModels;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String lastName;
    private String email;
    private String password;
}
