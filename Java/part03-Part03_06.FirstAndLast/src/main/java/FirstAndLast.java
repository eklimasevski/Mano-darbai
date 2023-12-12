
import java.util.ArrayList;
import java.util.Scanner;

public class FirstAndLast {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lastNumber = "";

        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            lastNumber = input;
            list.add(input);
        }
        System.out.println(list.get(0));
        System.out.println(lastNumber);
    }
}
