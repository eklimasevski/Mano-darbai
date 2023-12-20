import javax.crypto.spec.PSource;

public class MainProgram {

    public static void main(String[] args) {


        Pet lucy = new Pet("Lucy", "golden retriever");
        Person leo = new Person("Leo", lucy);

        System.out.println(leo);
    }
}

