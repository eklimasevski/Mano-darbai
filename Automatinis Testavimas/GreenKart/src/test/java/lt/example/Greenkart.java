package lt.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Greenkart {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setup() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void search() {

        driver.findElement(By.id("page-menu")).click();
        driver.findElement(By.cssSelector("option[value='20']")).click();

        WebElement inputSearch = driver.findElement(By.id("search-field"));
        inputSearch.sendKeys("ra");


        List<WebElement> products = driver.findElements(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(1)"));
        for (WebElement product : products) {
            assertTrue(product.getText().contains("ra"));
        }
    }

    @Test
    public void sorting() {

        driver.findElement(By.id("page-menu")).click();
        driver.findElement(By.cssSelector("option[value='20']")).click();
        driver.findElement(By.cssSelector(" th:nth-of-type(1) > span:nth-of-type(1)")).click();

        List<WebElement> products = driver.findElements(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(1)"));

        List<String> names = new ArrayList<>();
        for (WebElement product : products) {
            names.add(product.getText());
        }
        List<String> copyList = new ArrayList<>(names);
        Collections.sort(copyList);
        assertTrue(names.equals(copyList));
    }
}
