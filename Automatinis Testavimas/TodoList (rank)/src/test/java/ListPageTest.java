import It.example.BaseTest;
import org.example.ListPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListPageTest extends BaseTest {

    ListPage listPage;

    @Test
    void textAddToList() {

        String newItem = "123123";
        listPage = new ListPage(driver);
        listPage.setInput(newItem);
        listPage.getLastListText();
        assertEquals(newItem, listPage.getLastListText());
    }

    @Test
    void clickText() {
        listPage = new ListPage(driver);
        listPage.clickText();
        assertTrue(listPage.isLastElementCompleted());
    }

    @Test
    void deleteText() {
        listPage = new ListPage(driver);
        String lastTextBeforeDelete = listPage.getLastListText();
        listPage.deleteLastText();
        String lastTextAfterDelete = listPage.getLastListText();
        assertEquals(lastTextBeforeDelete, lastTextAfterDelete);
    }

    @Test
    void sameTextInList() {
        listPage = new ListPage(driver);
        assertTrue(listPage.searchText("Practice magic"));
    }

}
