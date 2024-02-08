package lt.example;

import org.example.ListPage;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListPageTest extends BasePageTest {

    ListPage listPage;


    @Test
    void search() {
        listPage = new ListPage(driver);
        listPage.clickOnPageSize();
        listPage.changeListSize("20");
        String text = "ra";
        listPage.searchInputField(text);


        List<String> copyList = new ArrayList<>(listPage.getProductNames());
        for (String product : copyList) {
            assertTrue(product.contains(text));
        }
    }

    @Test
    void sorting() {
        listPage = new ListPage(driver);
        listPage.clickOnPageSize();
        listPage.changeListSize("20");
        listPage.clickToSortAlphabeically();

//        List<String> INPUT_NAMES = Arrays.asList("a","b","c");
//        List<String> copyList = Arrays.asList("a","c","b");
//        Collections.sort(copyList);
//        assertTrue(INPUT_NAMES.equals(copyList));

        List<String> copyList = new ArrayList<>(listPage.getSortedProductNames());
        Collections.sort(copyList);
        assertTrue(listPage.getSortedProductNames().equals(copyList));
    }
}
