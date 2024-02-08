package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ListPage extends BasePage {

    @FindBy(css = "div#container > input[type='text']")
    WebElement input;

    @FindBy(xpath = "//div[@id='container']/ul/li[last()]")
    WebElement lastListText;

    @FindBy(xpath = "//div[@id='container']/ul/li")
    List<WebElement> allList;

    @FindBy(xpath = "//div[@id='container']/ul/li[last()]/span/i[@class='fa fa-trash']")
    WebElement deleteButton;


    public ListPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    public void setInput(String textToAdd) {
        actions.click(input).sendKeys(textToAdd).sendKeys(Keys.ENTER).perform();
    }

    public String getLastListText() {
        return lastListText.getText();
    }

    public void clickText() {
        actions.click(lastListText).perform();
    }

    public String classAttribute() {
        return lastListText.getAttribute("class");
    }

    public void deleteLastText() {

        actions.moveToElement(lastListText).perform();
        actions.click(deleteButton).perform();
    }

    public boolean isCompleted(String searchText) {
        for (WebElement element : allList) {
            if (element.getText().equals(searchText)) {
                return element.getAttribute("class").contains("completed");
            }
        }
        return false;
    }
    public boolean isLastElementCompleted(){
        return lastListText.getAttribute("class").contains("completed");
    }

    public boolean searchText(String searchText) {
        for (WebElement element : allList) {
            if (element.getText().equals(searchText)) {
                return true;
            }
        }
        return false;
    }

    public int elementsCount() {
        return allList.size();
    }


}