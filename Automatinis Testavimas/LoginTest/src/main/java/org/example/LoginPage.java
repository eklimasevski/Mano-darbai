package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[name='username']")
    WebElement usernameInput;

    @FindBy(css = "input[name='password']")
    WebElement passwordInput;

    @FindBy(css = "p[class='oxd-text oxd-text--p']")
    WebElement username;

    @FindBy(css = "p[class='oxd-text oxd-text--p']:nth-of-type(2)")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(css = "div[role='alert']")
    WebElement errorMessage;

    @FindBy(id = "dashboard-element-id")
    WebElement dashboard;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean messageAfterWrongLogin() {
        return errorMessage.isDisplayed();
    }

    public void enterUsername() {
        String getUsername = username.getText();
        usernameInput.sendKeys(getUsername.substring(getUsername.lastIndexOf(" "), getUsername.length()).trim());
    }

    public void wrongUsername() {
        usernameInput.sendKeys("123");
    }

    public void enterPassword() {
        String getPassword = password.getText();
        passwordInput.sendKeys(getPassword.substring(getPassword.lastIndexOf(" "), getPassword.length()).trim());
    }

    public void clickButton() {
        loginButton.click();
    }


}
