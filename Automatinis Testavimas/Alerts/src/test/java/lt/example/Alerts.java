package lt.example;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setup() {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");

    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void javaScriptButton() {
        WebElement clickButton = driver.findElement(By.id("button1"));
        clickButton.click();

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();
        String expectedMessage = "I am an alert box!";
        Assertions.assertEquals(expectedMessage, actualMessage);

        alert.accept();

    }

    @Test
    public void modalButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickButton = driver.findElement(By.id("button2"));
        clickButton.click();
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Close')]")));
        closeButton.click();
        WebElement titleText = driver.findElement(By.xpath("//h4[text()='It’s that Easy!!  Well I think it is.....']"));

        String expectedMessage = "It’s that Easy!! Well I think it is.....";
        Assertions.assertEquals(expectedMessage, titleText.getText());

    }


    @Test
    public void AjaxButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement clickButton = driver.findElement(By.id("button3"));
        clickButton.click();

        WebElement buttonAfterWait = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button1 > p")));
        buttonAfterWait.click();

        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Close')]")));
        closeButton.click();

        WebElement titleText = driver.findElement(By.xpath("//h4[text()='Well Done For Waiting....!!!']"));

        String expectedMessage = "Well Done For Waiting....!!!";
        Assertions.assertEquals(expectedMessage, titleText.getText());


    }

    @Test
    public void confirmButton() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickButton = driver.findElement(By.id("button4"));
        clickButton.click();

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();
        String expectedMessage = "Press a button!";
        Assertions.assertEquals(expectedMessage, actualMessage);
        alert.accept();

        WebElement confirmText = driver.findElement(By.xpath("//*[@id='confirm-alert-text']"));
//        WebElement confirmText = driver.findElement(By.xpath("//p[text()='You pressed OK!']"));
//        WebElement confirmText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='You pressed OK!']")));
//        Assertions.assertTrue(confirmText.isDisplayed());
        Assertions.assertEquals("You pressed OK!", confirmText.getText());
    }

}