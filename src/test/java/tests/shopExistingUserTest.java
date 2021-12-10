package tests;

import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

public class shopExistingUserTest extends TestBase {

    @Test
    public void logInAndRegister() throws InterruptedException {
        new MainPage(driver).goToLoginPage();

        new LoginPage(driver).logUserIn("barbararriddick@jourrapide.com", "12345678")
                .userExistsVerify("Barbara Riddick");

        new MainPage(driver).logUserOut();
    }
}
