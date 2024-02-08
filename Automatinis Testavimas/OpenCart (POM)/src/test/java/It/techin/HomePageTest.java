package It.techin;

import org.example.HomePage;
import org.example.LoginPage;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    @Test
    void openLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.clickDropdown();
        homePage.clickLinkLogin();
    }
}
