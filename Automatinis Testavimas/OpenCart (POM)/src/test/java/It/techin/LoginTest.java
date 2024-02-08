package It.techin;

import org.example.HomePage;
import org.example.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    HomePage homePage;

    LoginPage loginPage;

    @Test
    void canLogin() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickDropdown();
        homePage.clickLinkLogin();
        loginPage.enterEmail("Testukas123@gmail.com");
        loginPage.enterPassword("Testukas123");
        loginPage.clickLoginButton();
    }
}

