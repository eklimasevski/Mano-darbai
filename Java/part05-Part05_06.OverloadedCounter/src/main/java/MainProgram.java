
public class MainProgram {

    public static void main(String[] args) {

        Counter counter = new Counter();

        System.out.println("Start value: " + counter.value());

        counter.increase(5);
        System.out.println("+5: " + counter.value());

        counter.decrease(2);
        System.out.println("-2: " + counter.value());

        counter.increase(-3);
        System.out.println("+ -3: " + counter.value());

        counter.decrease(-1);
        System.out.println("-1: " + counter.value());
    }
}