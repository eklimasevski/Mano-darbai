public class Debt {

    private double balance;
    private double interesRate;

    public Debt(double initialBalance, double initialInterestRate) {
        this.balance = initialBalance;
        this.interesRate = initialInterestRate;
    }

    public void printBalance() {
        System.out.println(balance);
    }

    public void waitOneYear() {
        this.balance = this.balance * this.interesRate;
    }
}
