package It.Example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class Buttons {

    @Test
    public void clickButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");

        WebElement button = driver.findElement(By.id("button1"));
        button.click();

        Thread.sleep(500);
        WebElement popunInShow = driver.findElement(By.xpath("//*[@id='myModalMoveClick']"));
        WebElement titleText = driver.findElement(By.xpath("//h4[text()='Congratulations!']"));
        WebElement message = driver.findElement(By.xpath("//p[text()='Well done for successfully using the ']"));
        assertTrue(message.isDisplayed());
        assertTrue(titleText.isDisplayed());
        assertTrue(popunInShow.isEnabled());

        WebElement closeButton = driver.findElement(By.cssSelector("div#myModalClick > .modal-dialog.modal-sm .btn.btn-default"));
        closeButton.click();


        driver.quit();
    }

    @Test
    public void javaScriptClick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");

        WebElement button = driver.findElement(By.id("button2"));

        JavascriptExecutor click = (JavascriptExecutor) driver;
        click.executeScript("arguments[0].click();", button);

        Thread.sleep(500);
        WebElement popunInShow = driver.findElement(By.xpath("//*[@id='myModalJSClick']"));
        WebElement titleText = driver.findElement(By.xpath("//h4[text()='It’s that Easy!!  Well I think it is.....']"));
        WebElement message = driver.findElement(By.xpath("//p[text()='We can use JavaScript code if all else fails! Remember always try to use the WebDriver Library method(s) first such as WebElement.']"));
        assertTrue(message.isDisplayed());
        assertTrue(titleText.isDisplayed());
        assertTrue(popunInShow.isEnabled());

        WebElement closeButton = driver.findElement(By.cssSelector(".modal-dialog.modal-md .btn.btn-default"));
        closeButton.click();

        driver.quit();
    }

    @Test
    public void actionMoveClick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");

        WebElement button = driver.findElement(By.id("button3"));

        Actions clickButton = new Actions(driver);
        clickButton.click(button).perform();

        Thread.sleep(500);
        WebElement popunInShow = driver.findElement(By.xpath("//*[@id='myModalMoveClick']"));
        WebElement message = driver.findElement(By.xpath("//p[text()='Advanced user interactions (API) has been developed to enable you to perform more complex interactions such as:']"));
        WebElement titleText = driver.findElement(By.xpath("//h4[text()='Well done! the ']"));
        assertTrue(message.isDisplayed());
        assertTrue(titleText.isDisplayed());
        assertTrue(popunInShow.isEnabled());

        WebElement closeButton = driver.findElement(By.cssSelector("div#myModalMoveClick > .modal-dialog.modal-sm .btn.btn-default"));
        closeButton.click();

        driver.quit();

    }
}


