package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class MainPage extends BasePage {

    @FindBy(linkText = "QA")
    WebElement qaButton;

    @FindBy(xpath = "//button[@id='button-list']")
    WebElement listButton;

    @FindBy(css = "input#input-quantity")
    WebElement qtyInput;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='alert']/div")
    WebElement addToCartAlert;

    @FindBy(xpath = "//div[@id='header-cart']")
    WebElement cartButton;

    @FindBy(css = ".text-start > a")
    WebElement productInCart;

    @FindBy(css = ".btn-close")
    WebElement closeAlertButton;

    @FindBy(css = "tr > td:nth-of-type(3)")
    WebElement qtyInCart;

    @FindBy(css = ".price-new")
    WebElement productPrice;

    @FindBy(css = "tr > td:nth-of-type(4)")
    WebElement productPriceInCart;


    public void clickQaButton() {
        qaButton.click();
    }

    public void clickListButton() {
        listButton.click();
    }

    public String checkProductName(String input) {
        WebElement productName = driver.findElement(By.xpath("//h4/a[text()='" + input + "']"));
        return productName.getText();
    }

    public void clickOnProductImg(String input) {
        WebElement productImg = driver.findElement(By.cssSelector("img[alt='" + input + "']"));
        productImg.click();
    }

    public WebElement checkProductImg(String input) {
        WebElement productImg = driver.findElement(By.cssSelector("img[alt='" + input + "']"));
        return productImg;
    }

//    public boolean checkProductInList(String input) {
//        WebElement productImg = driver.findElement(By.cssSelector("img[alt='" + input + "']"));
//        if (!productImg.isDisplayed()) {
//            System.out.println(input + " does not exist in the eshop");
//            driver.close();
//        }
//        return false;
//    }

    public int changeRandomQty() {
        Random randomNumber = new Random();
        int randomInt = randomNumber.nextInt(20);
        qtyInput.clear();
        qtyInput.sendKeys(String.valueOf(randomInt));
        return randomInt;
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public WebElement checkCartAlert() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(addToCartAlert));
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public WebElement checkCart() {
        return productInCart;
    }

    public void closeAlert() {
        closeAlertButton.click();
    }

    public String checkQtyInCart() {
        return qtyInCart.getText();
    }

    public WebElement qtyInputAfter() {
        return qtyInput;
    }

    public String checkProductPrice() {
        return productPrice.getText();
    }

    public String checkProductPriceInCart() {
        return productPriceInCart.getText();
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
