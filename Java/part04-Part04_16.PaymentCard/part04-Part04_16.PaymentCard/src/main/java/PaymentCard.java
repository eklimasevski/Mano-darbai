public class PaymentCard {

    private double balance;
//    private String name;

    public PaymentCard(double balance) {
        this.balance = balance;
//        this.name = name;
    }

    public void eatAffordably() {
        if (balance >= 2.60) {
            balance -= 2.60;
        }
    }

    public void eatHeartily() {
        if (balance >= 4.60) {
            balance -= 4.60;
        }
    }

    public void addMoney(double amount) {

        if (amount >= 0) {
            balance += amount;
        }

        if (balance >= 150) {
            balance = 150;
        }
    }

    @Override
    public String toString() {
        return "The card has a balance of " + balance + " euros";
    }
}
