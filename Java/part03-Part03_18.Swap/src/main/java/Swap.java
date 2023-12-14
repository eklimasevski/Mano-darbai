
import java.util.Scanner;

public class Swap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 3;
        array[2] = 5;
        array[3] = 7;
        array[4] = 9;

        int index = 0;
        while (index < array.length) {
            System.out.println(array[index]);
            index++;
        }
        System.out.println("");

        System.out.println("Give two indices to swap:");
        int numberOne = Integer.valueOf(scanner.nextLine());
        int numberTwo = Integer.valueOf(scanner.nextLine());

        int number = array[numberOne];

        array[numberOne] = array[numberTwo];
        array[numberTwo] = number;

        index = 0;
        while (index < array.length) {
            System.out.println(array[index]);
            index++;
        }

    }
}