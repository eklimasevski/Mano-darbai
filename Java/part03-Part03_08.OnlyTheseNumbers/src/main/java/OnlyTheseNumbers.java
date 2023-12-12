


import java.util.ArrayList;
import java.util.Scanner;

public class OnlyTheseNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == -1) {
                break;
            }

            numbers.add(number);

        }

        System.out.println("From where?");
        int firstNumber = Integer.valueOf(scanner.nextLine());

        System.out.println("to where?");
        int lastNumber = Integer.valueOf(scanner.nextLine());

        for (int i = firstNumber; i <= lastNumber; i++) {
            System.out.println(numbers.get(i));
        }
    }
}
