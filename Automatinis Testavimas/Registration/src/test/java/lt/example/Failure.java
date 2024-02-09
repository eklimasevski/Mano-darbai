package lt.example;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class Failure implements AfterTestExecutionCallback {

    public static WebDriver driver;


    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if (context.getExecutionException().isPresent()) {
            TestUtils.takeScreenshot(driver, context.getDisplayName());
        }
    }

}