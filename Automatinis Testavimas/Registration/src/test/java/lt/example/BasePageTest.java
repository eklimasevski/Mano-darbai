package lt.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;


import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

@ExtendWith(Failure.class)
public class BasePageTest {

    public static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        String URL = "https://practice.expandtesting.com/notes/app";
        driver.get(URL);
        Failure.driver = this.driver;
        log.info("Open Home Page.");
    }

    @AfterEach
    void tearDown() {
        driver.close();
        log.info("WebDriver closed");
    }
}
