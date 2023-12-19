public class Counter {

    private int value;

    public Counter(int startValue) {
        value = startValue;
    }

    public Counter() {
        value = 0;
    }

    public int value() {
        return this.value;
    }

    public void increase() {
        value++;
    }

    public void decrease() {
        value--;
    }

    public void increase(int increaseBy) {
        if (increaseBy > 0) {
            value += increaseBy;
        }
    }

    public void decrease(int decreaseBy) {
        if (decreaseBy > 0) {
            value -= decreaseBy;
        }
    }

}

