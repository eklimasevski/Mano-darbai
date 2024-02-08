package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage {

    @FindBy(css = "input#item-name")
    WebElement mealName;

    @FindBy(css = "input#item-calories")
    WebElement caloriesQuantity;

    @FindBy(css = ".add-btn.blue.btn.darken-3")
    WebElement addToListButton;

    @FindBy(css = "ul#item-list > li:nth-of-type(1)")
    WebElement firstOfList;

    @FindBy(css = "ul#item-list > li")
    List<WebElement> mealsList;

    @FindBy(linkText = "CLEAR ALL")
    WebElement clearButton;

    @FindBy(xpath = "/html//h3[@class='center-align']")
    WebElement totalCalories;

    @FindBy(css = ".edit-item.fa.fa-pencil")
    WebElement editButton;

    @FindBy (css = ".btn.delete-btn.red")
    WebElement deleteButton;

    @FindBy(css = ".btn.orange.update-btn")
    WebElement updateButton;

    public void enterMeal(String meal) {
        mealName.sendKeys(meal);
    }

    public WebElement getMeal(){
        return mealName;
    }

    public WebElement getCalories(){
        return caloriesQuantity;
    }

    public void enterCalories(Integer calories) {
        caloriesQuantity.sendKeys(calories.toString());
    }

    public void clickAddButton() {
        addToListButton.click();
    }

    public boolean checkOrAdded() {
        return firstOfList.isDisplayed();
    }


    public List<String> checkAllList() {
        List<String> mealTexts = new ArrayList<>();
        for (WebElement mealList : mealsList) {
            String mealText = mealList.getText();
            mealTexts.add(mealText);
        }
        return mealTexts;
    }

    public void clickClearButton() {
        clearButton.click();
    }

    public String sumTotalCalories() {
        return totalCalories.getText();
    }

    public void clickEditButton() {
        editButton.click();
    }
    public void clickDeleteButton(){
        deleteButton.click();
    }

    public void clickUpdateButton(){
        updateButton.click();
    }

    public ListPage(WebDriver driver) {
        super(driver);
    }
}
