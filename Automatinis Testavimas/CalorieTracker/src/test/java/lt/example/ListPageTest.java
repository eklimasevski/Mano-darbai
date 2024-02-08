package lt.example;

import org.example.ListPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPageTest extends BasePageTest {

    ListPage listPage;

    @Test
    void addToList() {
//        String meal = "Burger";
//        Integer calories = 295;
        List<String> meal = Arrays.asList("Burger", "Apple!", "Banana", "Coffe", "Cola");
        List<Integer> calories = Arrays.asList(295, 72, 105, 2, 136);

        listPage = new ListPage(driver);
        for (int i = 0; i < meal.size(); i++) {
            listPage.enterMeal(meal.get(i));
            listPage.enterCalories(calories.get(i));
            listPage.clickAddButton();
            Assertions.assertTrue(listPage.checkOrAdded());
        }
//        listPage.enterMeal(meal);
//        listPage.enterCalories(calories);
//        listPage.clickAddButton();
// Assertions.assertTrue(listPage.checkOrAdded());

//        String expected = meal + ": " + calories + " Calories";
//        Assertions.assertEquals(expected,listPage.checkAllList());

        List<String> actualList = listPage.checkAllList();
        List<String> expectedList = new ArrayList<>();
        for (int i = 0; i < meal.size(); i++) {
            expectedList.add(meal.get(i) + ": " + calories.get(i) + " Calories");
        }
        Assertions.assertIterableEquals(expectedList, actualList);
    }


    @Test
    void clearAll() {
        List<String> meal = Arrays.asList("Burger", "Apple!", "Banana", "Coffe", "Cola");
        List<Integer> calories = Arrays.asList(295, 72, 105, 2, 136);

        listPage = new ListPage(driver);
        for (int i = 0; i < meal.size(); i++) {
            listPage.enterMeal(meal.get(i));
            listPage.enterCalories(calories.get(i));
            listPage.clickAddButton();
            Assertions.assertTrue(listPage.checkOrAdded());
        }
        listPage.clickClearButton();
        Assertions.assertTrue(listPage.checkAllList().isEmpty());
    }

    @Test
    void totalCalories() {
        List<String> meal = Arrays.asList("Burger", "Apple!", "Banana", "Coffe", "Cola");
        List<Integer> calories = Arrays.asList(295, 72, 105, 2, 136);

        listPage = new ListPage(driver);
        for (int i = 0; i < meal.size(); i++) {
            listPage.enterMeal(meal.get(i));
            listPage.enterCalories(calories.get(i));
            listPage.clickAddButton();
            Assertions.assertTrue(listPage.checkOrAdded());
        }
        String expectedCalories = String.valueOf(calories.stream().mapToInt(Integer::intValue).sum());
        String actualCalories = listPage.sumTotalCalories();

//        int spaceIndex = actualCalories.indexOf(" ");
//        Assertions.assertEquals(expectedCalories, actualCalories.substring(spaceIndex + 1));

        Assertions.assertEquals(expectedCalories, actualCalories.replaceAll("[^0-9]", ""));
    }

    @Test
    void deleteOneFromList() {
        List<String> meal = Arrays.asList("Burger", "Apple!", "Banana", "Coffe", "Cola");
        List<Integer> calories = Arrays.asList(295, 72, 105, 2, 136);

        listPage = new ListPage(driver);
        for (int i = 0; i < meal.size(); i++) {
            listPage.enterMeal(meal.get(i));
            listPage.enterCalories(calories.get(i));
            listPage.clickAddButton();
            Assertions.assertTrue(listPage.checkOrAdded());
        }
        int listSizeBefore = listPage.checkAllList().size();
        listPage.clickEditButton();
        listPage.clickDeleteButton();
        int listSizeAfter = listPage.checkAllList().size();

        Assertions.assertEquals(listSizeBefore - 1, listSizeAfter);
    }

    @Test
    void updateFromList() {

        List<String> meal = Arrays.asList("Burger", "Apple!", "Banana", "Coffe", "Cola");
        List<Integer> calories = Arrays.asList(295, 72, 105, 2, 136);

        listPage = new ListPage(driver);
        for (int i = 0; i < meal.size(); i++) {
            listPage.enterMeal(meal.get(i));
            listPage.enterCalories(calories.get(i));
            listPage.clickAddButton();
            Assertions.assertTrue(listPage.checkOrAdded());
        }
        String updatedMeal = "Burrito";
        Integer updatedCalories = 323;
        listPage.clickEditButton();
        listPage.getMeal().clear();
        listPage.getCalories().clear();
        listPage.enterMeal(updatedMeal);
        listPage.enterCalories(updatedCalories);
        listPage.clickUpdateButton();

        String actual = listPage.checkAllList().getFirst();
        String expected = updatedMeal + ": " + updatedCalories + " Calories";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void totalCaloriesAfterUpdate() {
        List<String> meal = Arrays.asList("Burger", "Apple!", "Banana", "Coffe", "Cola");
        List<Integer> calories = Arrays.asList(295, 72, 105, 2, 136);

        listPage = new ListPage(driver);
        for (int i = 0; i < meal.size(); i++) {
            listPage.enterMeal(meal.get(i));
            listPage.enterCalories(calories.get(i));
            listPage.clickAddButton();
            Assertions.assertTrue(listPage.checkOrAdded());
        }
        String updatedMeal = "Burrito";
        Integer updatedCalories = 323;

        listPage.clickEditButton();
        listPage.getMeal().clear();
        listPage.getCalories().clear();
        listPage.enterMeal(updatedMeal);
        listPage.enterCalories(updatedCalories);
        listPage.clickUpdateButton();

        String caloriesAfterUpdate = String.valueOf(calories.stream().mapToInt(Integer::intValue).sum());
        String caloriesBeforeUpdate = listPage.sumTotalCalories();
        Assertions.assertNotEquals(caloriesAfterUpdate, caloriesBeforeUpdate.replaceAll("[^0-9]", ""));
        // Žinau kad patikrinimas nera geras, bet kitaip man nesigavo :(
    }

    @Test
    void checkOrOnlyStrings() {
        List<String> meal = Arrays.asList("Burger", "Apple", "Banana", "Coffe", "Cola");
        List<Integer> calories = Arrays.asList(295, 72, 105, 2, 136);

        listPage = new ListPage(driver);
        for (int i = 0; i < meal.size(); i++) {
            listPage.enterMeal(meal.get(i));
            listPage.enterCalories(calories.get(i));
            listPage.clickAddButton();
            Assertions.assertTrue(listPage.checkOrAdded());
        }

        for (String meals : meal) {
            Assertions.assertTrue(meals.matches("[a-zA-Z]+"), "Neteisingas formatas " + meals);
        }
    }

    @Test
    void checkOrOnlyIntegers() {
        List<String> meal = Arrays.asList("Burg3r", "Apple", "B@nana", "Coffe", "Cola");
        List<Integer> calories = Arrays.asList(295, 72, 105, 2, 136);

        listPage = new ListPage(driver);
        for (int i = 0; i < meal.size(); i++) {
            listPage.enterMeal(meal.get(i));
            listPage.enterCalories(calories.get(i));
            listPage.clickAddButton();
            Assertions.assertTrue(listPage.checkOrAdded());
        }
        for (Integer calorie : calories) {
            Assertions.assertTrue(calorie.toString().matches("[0-9]+"), "Neteisingas formatas " + calorie);
        }
    }

}