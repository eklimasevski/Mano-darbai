public class Statistics {
    private int count;
    private int sum;

    public Statistics() {
    }

    public void addNumber(int number) {
        sum = sum + number;
        count++;
    }

    public int getCount() {
        return count;
    }

    public int sum() {
        return sum;
    }

    public double average() {
        if (count == 0) {
            return 0;
        } else {
            return sum / (double) count;
        }
    }
}


