import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PersonalInformation> personalInformations = new ArrayList<>();

        while (true) {

            System.out.println("First name: ");
            String firstName = scanner.nextLine();

            if (firstName.isEmpty()) {
                break;
            }

            System.out.println("Last name: ");
            String lastName = scanner.nextLine();

            System.out.println("Identification number: ");
            String identification = scanner.nextLine();

            personalInformations.add(new PersonalInformation(firstName, lastName, identification));

        }
        for (PersonalInformation person : personalInformations) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }
    }
}
