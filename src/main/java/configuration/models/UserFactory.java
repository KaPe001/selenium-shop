package configuration.models;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class UserFactory {
    public User getRandomUser() {
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        User user = new UserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .emailAddress(fakeValuesService.bothify("????##@gmail.com"))
                .password(fakeValuesService.regexify("[a-z1-9]{10}"))
                .build();
        return user;
    }

    public User getAlreadyRegisteredUser() {

        User user = new UserBuilder()
                .firstName("Jan")
                .lastName("Kowalski")
                .emailAddress("jakis@mail.com")
                .password("dsald22")
                .build();
        return user;
    }
}
