package It.example;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ActionTest {


    @Test
    public void DragTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://webdriveruniversity.com/Actions/index.html");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        WebElement clickButton = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(draggable, droppable).perform();

        String actualBackgroundColor = droppable.getCssValue("background-color");
        String expectedBackgroundColor = droppable.getCssValue("background-color: rgb(244, 89, 80)");
        assertNotEquals(expectedBackgroundColor, actualBackgroundColor);

        String actualText = clickButton.getText();
        String expectedText = "Dropped!";
        assertEquals(expectedText, actualText);

        driver.quit();
    }

    @Test

    public void doubleClick() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://webdriveruniversity.com/Actions/index.html");

        WebElement Click = driver.findElement(By.id("double-click"));

        Actions actionsDouble = new Actions(driver);
        actionsDouble.doubleClick(Click).perform();

        String actualColor = Click.getCssValue("background-color");
        String expectedColor = "rgba(147, 203, 90, 1)";
        assertEquals(expectedColor, actualColor);

        driver.quit();
    }

    @Test
    public void hover() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Actions/index.html");

        WebElement hoverFirst = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        WebElement hoverSecond = driver.findElement(By.xpath("//button[text()='Hover Over Me Second!']"));
        WebElement hoverThird = driver.findElement(By.xpath("//button[text()='Hover Over Me Third!']"));

        Actions actionsHover = new Actions(driver);

        actionsHover.moveToElement(hoverFirst).perform();
        WebElement subMenu = driver.findElement(By.cssSelector("a[class='list-alert']"));
        assertTrue(subMenu.isDisplayed());

        actionsHover.moveToElement(hoverSecond).perform();
        WebElement subMenuSecond = driver.findElement(By.xpath("//button[text()='Hover Over Me Second!']/..//a"));
        assertTrue(subMenuSecond.isDisplayed());

        actionsHover.moveToElement(hoverThird).perform();
        WebElement subMenuThird = driver.findElement(By.xpath("//button[text()='Hover Over Me Third!']/..//a"));
        assertTrue(subMenuThird.isDisplayed());

        driver.quit();
    }

    @Test
    public void clickAndHold() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://webdriveruniversity.com/Actions/index.html");

        WebElement clickButton = driver.findElement(By.id("click-box"));

        Actions actionsClick = new Actions(driver);
        actionsClick.clickAndHold(clickButton).perform();

        String actualColor = clickButton.getCssValue("background-color");
        String expectedColor = "rgba(0, 255, 0, 1)";
        assertEquals(expectedColor, actualColor);

        String actualText = clickButton.getText();
        String expectedText = "Well done! keep holding that click now.....";
        assertEquals(expectedText, actualText);

        driver.quit();
    }

}