package lt.example;

import org.example.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BasePageTest {

    LoginPage loginPage;

    @Test
    void login() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickButton();
    }
}
