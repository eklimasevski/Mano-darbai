package lt.example;

import org.example.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LoginPageTest extends BasePageTest {

    LoginPage loginPage;

    @Test
    void login() {
        loginPage = new LoginPage(driver);
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickButton();
        String actualURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, actualURL);
    }

    @Test
    void wrongLogin() {
        loginPage = new LoginPage(driver);
        loginPage.wrongUsername();
        loginPage.enterPassword();
        loginPage.clickButton();
        Assertions.assertTrue(loginPage.messageAfterWrongLogin());
    }
}
