import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Title: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Pages: ");
            int pages = Integer.valueOf(scanner.nextLine());

            System.out.print("Publication year: ");
            int pubYear = Integer.valueOf(scanner.nextLine());

            books.add(new Book(name, pages, pubYear));
        }

        System.out.print("What information will be printed? ");
        String all = scanner.nextLine();

        for (Book book : books) {
            if (all.equals("everything")) {
                System.out.println(book);
            } else if (all.equals("name")) {
                System.out.println(book.getName());
            }
        }
    }
}
