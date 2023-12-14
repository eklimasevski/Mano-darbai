
public class ArrayPrinter {

    public static void main(String[] args) {

        int[] numbers = {5, 1, 3, 4, 2};

        printNeatly(numbers);

    }

    public static void printNeatly(int[] array) {


        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
    }
}