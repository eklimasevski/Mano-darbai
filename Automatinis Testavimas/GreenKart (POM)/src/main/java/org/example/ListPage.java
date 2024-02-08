package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage {

    @FindBy(id = "page-menu")
    WebElement pageSize;

    @FindBy(css = "#page-menu")
    WebElement pageSizeNumbers;

    @FindBy(id = "search-field")
    WebElement searchInput;

    @FindBy(css = " th:nth-of-type(1) > span:nth-of-type(1)")
    WebElement sortByAlphabet;

    @FindBy(css = "tr:nth-of-type(1) > td:nth-of-type(1)")
    List<WebElement> productsList;

    public ListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPageSize() {
        pageSize.click();
    }

    public void changeListSize(String value) {
        Select select = new Select(pageSizeNumbers);
       select.selectByValue(value);
    }

    public void searchInputField(String text) {
        searchInput.sendKeys(text);
    }

    public void clickToSortAlphabeically() {
        sortByAlphabet.click();
    }

    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<>();
        for (WebElement product : productsList) {
            String productName = product.getText();
            productNames.add(productName);
        }
        return productNames;
    }


    public List<String> getSortedProductNames() {
        List<String> productNames = new ArrayList<>();
        for (WebElement product : productsList) {
            String productName = product.getText();
            productNames.add(productName);
        }
        return productNames;
    }
}
