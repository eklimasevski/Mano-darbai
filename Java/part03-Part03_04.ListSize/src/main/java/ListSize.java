
import java.util.ArrayList;
import java.util.Scanner;

public class ListSize {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayList<String> list = new ArrayList<>();
        while (true) {

            int values = list.size();
            String input = scanner.nextLine();

            if (input.equals("")) {
                System.out.printf("In total: " + values);
                break;
            }

            list.add(input);

        }

    }
}
