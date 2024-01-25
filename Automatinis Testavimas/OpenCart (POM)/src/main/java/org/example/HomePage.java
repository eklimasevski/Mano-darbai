package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[title='My Account']")
    WebElement dropdown;

    @FindBy(linkText = "Login")
    WebElement linkLogin;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdown() {
        dropdown.click();
    }

    public void clickLinkLogin() {
        linkLogin.click();
    }

}
