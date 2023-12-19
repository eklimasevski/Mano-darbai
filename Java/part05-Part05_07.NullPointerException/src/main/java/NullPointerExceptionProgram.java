
public class NullPointerExceptionProgram {

    public static void main(String[] args) {

        Person joan = new Person();
        System.out.println(joan);

        joan = null;
        joan.addValue();
        System.out.println(joan);


    }
}
