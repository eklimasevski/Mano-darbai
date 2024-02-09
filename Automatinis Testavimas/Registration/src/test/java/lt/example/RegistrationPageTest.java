package lt.example;

import org.example.RegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;


public class RegistrationPageTest extends BasePageTest {
    private static final Logger log = getLogger(lookup().lookupClass());
    RegistrationPage registrationPage;

    @Test
    void createAccount() {
        registrationPage = new RegistrationPage(driver);

        String expected = "User account created successfully";
        String email = registrationPage.getEmail();
        String name = "Testas";
        String password = "Testukas123";

        registrationPage.clickCreateAccount();
        registrationPage.enterEmail(email);
        registrationPage.enterName(name);
        registrationPage.enterPassword(password);
        registrationPage.enterPasswordConfirm(password);
        registrationPage.clickToRegistration();

        log.info("Attempting to register, your details - Email: {}, Name: {}, Password: {}.", email, name, password);

        String actual = registrationPage.actualRegistrationMessage();
        Assertions.assertEquals(expected, actual, "Regestration has failed");

        log.info("Successful regestration!");

        registrationPage.clickToStartLogin();
        log.info("Trying to login - Email: {}, Password: {}.", email, password);

        registrationPage.enterLogin(email, password);
        registrationPage.clickToLogin();

        log.info("successfully logged in!");
    }

    @Test
    void loginFail() {
        registrationPage = new RegistrationPage(driver);

        registrationPage.clickLogin();
        String email = registrationPage.getEmail();
        String password = "Testukas123";
        String expectedErrorMesssge = "Incorrect email address or password";

        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);

        log.info("Trying to login - Email: {}, Password: {}.", email, password);

        registrationPage.clickToLogin();

        Assertions.assertNotEquals(expectedErrorMesssge, registrationPage.errorMessage());
        log.info("successfully logged in!");
    }
}