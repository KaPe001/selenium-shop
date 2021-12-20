package tests;

import configuration.models.UserFactory;
import org.junit.jupiter.api.Test;

public class TestForUser {

    @Test
    public void getUserInfo(){

        UserFactory userFactory = new UserFactory();

        System.out.println(userFactory.getAlreadyRegisteredUser());
        System.out.println(userFactory.getRandomUser());

    }
}
