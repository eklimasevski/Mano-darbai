public class Gauge {
    private int value;

    public Gauge() {
        this.value = 0;
    }

    public void increase() {
        if (value < 5) {
            value += 1;
        }
    }

    public int value() {
        return value;
    }

    public void decrease() {
        if (value > 0) {
            value -= 1;
        }
    }

    public boolean full() {
        if (value != 5) {
            return false;
        }
        return true;
    }

}
