import javax.swing.*;

public class YourFirstAccount {

    public static void main(String[] args) {

        Account rosesAccount = new Account("Rose's account", 100.00);

        rosesAccount.deposit(20);
        System.out.println(rosesAccount);

    }
}
