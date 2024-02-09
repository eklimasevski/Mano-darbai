package lt.example;

import org.example.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;


public class MainPageTest extends BasePageTest {

    MainPage mainPage;

    @ParameterizedTest
    @ValueSource(strings = {"Code Confusion Raccoon", "Debug Duck", "Java Genius Duck", "Code Calm pills"})
    void findElement(String input) {

        String expected = "Success: You have added " + input + " to your shopping cart!";

        mainPage = new MainPage(driver);
        mainPage.clickQaButton();
        mainPage.clickListButton();

//        mainPage.checkProductInList(input);

//        if (!mainPage.checkProductImg(input).isDisplayed()) {
//            System.out.println(input + " does not exist in the eshop");
//            driver.close();
//        }

        Assertions.assertTrue(mainPage.checkProductImg(input).isDisplayed());
        Assertions.assertEquals(input, mainPage.checkProductName(input), "Product not found");


        mainPage.clickOnProductImg(input);
        mainPage.changeRandomQty();
        mainPage.clickAddToCart();

        Assertions.assertEquals(expected, mainPage.checkCartAlert().getText(), "Alert has not appeared");

        mainPage.closeAlert();
        mainPage.clickCartButton();

        String expectedQty = mainPage.qtyInputAfter().getAttribute("value");

        Assertions.assertEquals(input, mainPage.checkCart().getText(), "Product name is incorrect");
        Assertions.assertEquals("x " + expectedQty, mainPage.checkQtyInCart(), "quantity incorrect");

        String actualPriceString = mainPage.checkProductPrice().replace("$", "");

        double actualPrice = Double.parseDouble(actualPriceString);
        double actualQty = Double.parseDouble(expectedQty);
        double priceSum = (actualPrice * actualQty);

        String expectedPriceString = mainPage.checkProductPriceInCart().replace("$", "");
        double expectedPrice = Double.parseDouble(expectedPriceString);

        Assertions.assertEquals(expectedPrice, priceSum, 0.01);
    }

}