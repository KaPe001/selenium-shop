package tests;

import TestBase.TestBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

@Execution(ExecutionMode.CONCURRENT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class shopLogUserTest extends TestBase {

    @Order(1)
    @DisplayName("log in existing user")
    @Test
    public void logInExistingUser() {
        LoginPage loginPage = new LoginPage(webDriver);

        new MainPage(webDriver)
                .goToLoginPage();

        new LoginPage(webDriver)
                .logUserIn("barbararriddick@jourrapide.com", "12345678")
                .submitUser();
        Assertions.assertEquals(loginPage.getAccountName(), "Barbara Riddick");

        new MainPage(webDriver).logUserOut();
    }

    @Order(2)
    @DisplayName("log in non-existing user")
    @Test
    public void logInNonExistingUser() {
        MainPage mainPage = new MainPage(webDriver);

        new MainPage(webDriver).goToLoginPage();

        new LoginPage(webDriver).logUserIn("randomEmail@email.com", "randomPassword")
                .submitUser()
                .getAlert();

        new RegisterPage(webDriver)
                .getUserGender()
                .getUserFirstNameLastName("Jan", "Kowalski")
                .getEmail()
                .getPassword("123456789")
                .giveConsent()
                .saveUserRegistration();

        Assertions.assertEquals("Jan Kowalski", mainPage.verifyLoggedUserInfo());

        new MainPage(webDriver)
                .logUserOut();
    }
}
