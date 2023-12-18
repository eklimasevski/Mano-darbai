import java.util.ArrayList;
import java.util.Scanner;

public class GreatestInList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        int greatestNumber = 0;
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }

            list.add(input);
        }
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            if (greatestNumber < number) {
                greatestNumber = number;
            }
        }

        System.out.println("The greatest number: " + greatestNumber);

        // implement finding the greatest number in the list here
    }
}
