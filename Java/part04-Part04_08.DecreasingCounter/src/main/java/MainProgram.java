
public class MainProgram {

    public static void main(String[] args) {

        DecreasingCounter counter = new DecreasingCounter(2);

        counter.printValue();

        counter.reset();
        counter.printValue();

        counter.decrement();
        counter.printValue();
    }
}
