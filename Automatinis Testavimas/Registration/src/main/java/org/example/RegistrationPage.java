package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;
import java.util.Random;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class RegistrationPage extends BasePage {
    private static final Logger log = getLogger(lookup().lookupClass());
    @FindBy(linkText = "Create an account")
    WebElement createAccountButton;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    WebElement confirmPasswordInput;

    @FindBy(css = ".btn.btn-lg.btn-primary.d-block.w-100")
    WebElement registrationButton;

    @FindBy(css = "b")
    WebElement actualMessage;

    @FindBy(linkText = "Click here to Log In")
    WebElement loginButton;

    @FindBy(xpath = "//form//button[@type='submit']")
    WebElement loginSubmit;

    @FindBy(linkText = "Login")
    WebElement homePageLoginButton;

    @FindBy(css = ".toast-body")
    WebElement loginErrorMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
        log.info("Navigate to Registration Page.");
    }


    public void enterEmail(String text) {
        emailInput.sendKeys(text);
    }

    public void enterName(String text) {
        nameInput.sendKeys(text);
    }

    public void enterPassword(String text) {
        passwordInput.sendKeys(text);
    }

    public void enterPasswordConfirm(String text) {
        confirmPasswordInput.sendKeys(text);
    }

    public void clickToRegistration() {
        registrationButton.click();
    }

    public String actualRegistrationMessage() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(actualMessage));
        return actualMessage.getText();
    }

    public void clickToStartLogin() {
        loginButton.click();
        log.info("Redirection to the login page.");
    }

    public void enterLogin(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickToLogin() {
        loginSubmit.click();
    }


    public String getEmail() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }

    public void clickLogin() {
        homePageLoginButton.click();
        log.info("Redirection to the login page.");
    }

    public String errorMessage() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginErrorMessage));
        return loginErrorMessage.getText();
    }
}