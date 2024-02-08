package It.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class toDoList {


    @Test
    public void addList() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");

        WebElement click = driver.findElement(By.cssSelector("div#container > input[type='text']"));

        Actions actions = new Actions(driver);
        String textToAdd = "Testukas123";

        actions.click(click).sendKeys(textToAdd).sendKeys(Keys.ENTER).perform();

        WebElement listElement = driver.findElement(By.xpath("//div[@id='container']/ul/li[last()]"));
        String addedText = listElement.getText();
        assertEquals(addedText, textToAdd);

        driver.quit();
    }

    @Test
    public void copleted() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");

        WebElement clickElement = driver.findElement(By.xpath("//div[@id='container']/ul/li[last()]"));

        Actions actions = new Actions(driver);
        actions.click(clickElement).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(clickElement, "class", "completed"));

        String classAttribute = clickElement.getAttribute("class");
        assertTrue(classAttribute.contains("completed"));

        driver.quit();
    }


    @Test
    public void delete() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");

        List<WebElement> listBefore = driver.findElements(By.xpath("//div[@id='container']/ul/li"));
        int initialListSize = listBefore.size();

        WebElement hover = driver.findElement(By.xpath("//div[@id='container']/ul/li[last()]"));
        WebElement click = driver.findElement(By.xpath("//div[@id='container']/ul/li[last()]/span/i[@class='fa fa-trash']"));

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(hover));
        actions.moveToElement(hover).perform();

        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(click));
        actions.click(click).perform();

        Thread.sleep(1000);

        List<WebElement> listAfter = driver.findElements(By.xpath("//div[@id='container']/ul/li"));
        int finalListSize = listAfter.size();
        assertEquals(initialListSize - 1, finalListSize);

        driver.quit();


    }
}