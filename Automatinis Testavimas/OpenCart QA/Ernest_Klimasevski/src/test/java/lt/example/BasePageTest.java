package lt.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePageTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        String URL = "http://192.168.88.86/";
        driver.get(URL);
    }

    @AfterEach
    void tearDown() {
        driver.close();

    }
}
