package tests;

import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class ShopNonExistingUserTest extends TestBase {

    @Test
    public void logInNonExistingUser() throws InterruptedException {
        new MainPage(driver).goToLoginPage();

        new LoginPage(driver).logUserIn("randomEmail@email.com", "randomPassword")
                .whenUserDoesntExistGetAlert();

        new RegisterPage(driver)
                .getUserGender()
                .getUserFirstNameLastName("Jan", "Kowalski")
                .getEmail()
                .getPassword("123456789")
                .giveConsent()
                .saveUserRegistration();

        new MainPage(driver)
                .verifyLoggedUserInfo()
                .logUserOut();
    }
}
