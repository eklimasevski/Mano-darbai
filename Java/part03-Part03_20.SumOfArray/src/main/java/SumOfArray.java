
public class SumOfArray {

    public static void main(String[] args) {

        int[] numbers = {4, 1, 3, 4, 2};

        sumOfNumbersInArray(numbers);

        System.out.println(sumOfNumbersInArray(numbers));
    }

    public static int sumOfNumbersInArray(int[] array) {

        int sum = 0;

        for (int number : array) {
            sum += number;
        }

        return sum;
    }
}
