package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[name='username']")
    WebElement usernameInput;

    @FindBy(css = "input[name='password']")
    WebElement passwordInput;

    @FindBy(css = ".orangehrm-demo-credentials.oxd-sheet.oxd-sheet--gray-lighten-2.oxd-sheet--gutters.oxd-sheet--rounded > p:nth-of-type(1)")
    WebElement username;

    @FindBy(css = ".orangehrm-demo-credentials.oxd-sheet.oxd-sheet--gray-lighten-2.oxd-sheet--gutters.oxd-sheet--rounded > p:nth-of-type(2)")
    WebElement password;

    @FindBy(xpath = "//div[@id='app']/div[@class='orangehrm-login-layout']/div[@class='orangehrm-login-layout-blob']//form[@action='/web/index.php/auth/validate']/div[3]/button[@type='submit']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername() {
        String getUsername = username.getText();
        usernameInput.sendKeys(getUsername.substring(getUsername.lastIndexOf(" "), getUsername.length()).trim());
    }

    public void enterPassword() {
        String getPassword = password.getText();
        passwordInput.sendKeys(getPassword.substring(getPassword.lastIndexOf(" "), getPassword.length()).trim());
    }

    public void clickButton() {
        loginButton.click();
    }

}
