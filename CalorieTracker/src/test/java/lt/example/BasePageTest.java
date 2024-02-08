package lt.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePageTest {
    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/tracalorie/?classId=41841eb1-496c-4d1b-ba53-62af75112909&assignmentId=eb6d84d3-f1fe-4612-9bd9-ed6ca2feacfe&submissionId=9732e229-a29c-d2fa-f85b-6be3d349aa1c");
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}