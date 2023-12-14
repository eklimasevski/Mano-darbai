
public class ArrayPrinter {

    public static void main(String[] args) {

        int[] numbers = {5, 1, 3, 4, 2};

        printNeatly(numbers);

    }

    public static void printNeatly(int[] array) {

        int count = 0;

        for (int number : array) {
            System.out.print(number);

            if (count < array.length - 1) {
                System.out.print(",");
            }
            count++;

//            for (int numbers = 0; numbers < array.length; numbers++){
//                System.out.print(array[numbers]);
//
//                if (numbers < array.length - 1) {
//                    System.out.print(", ");
//            }
//        }
        }
    }
}