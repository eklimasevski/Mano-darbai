package It.techin;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

    public class OpenCart {

        @Test
        public void loginTest() {

            WebDriver driver = new ChromeDriver();

            driver.get("https://demo.opencart-extensions.co.uk");

            WebElement accountLink = driver.findElement(By.cssSelector("a[title='My Account']"));
            accountLink.click();

            WebElement loginLink = driver.findElement(By.linkText("Login"));
            loginLink.click();

            WebElement emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("Testukas123@gmail.com");

            WebElement passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("Testukas123");

            WebElement loginButton = driver.findElement(By.cssSelector("[value='Login']"));
            loginButton.click();

            driver.quit();
        }
        @Test
        public void wrongLoginTest(){
            WebDriver driver = new ChromeDriver();

            driver.get("https://demo.opencart-extensions.co.uk");

            WebElement accountLink = driver.findElement(By.cssSelector("a[title='My Account']"));
            accountLink.click();

            WebElement loginLink = driver.findElement(By.linkText("Login"));
            loginLink.click();

            WebElement emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("Testukas123@gmail.com");

            WebElement passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("Testukas");

            WebElement loginButton = driver.findElement(By.cssSelector("[value='Login']"));
            loginButton.click();

            WebElement errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger"));
            String expectedError = "Warning: No match for E-Mail Address and/or Password.";
            assertEquals(expectedError, errorMessage.getText());

            driver.quit();

        }
    }


