import java.rmi.Naming;

public class Client {

    public static void main(String[] args) {
        try {
            Account account = (Account) Naming.lookup("rmi://localhost:2023/monChat");

            account.changeAmount(-1000);
            account.changeAmount(10);
            System.out.println("Amount is : " + account.getAmount());

        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
