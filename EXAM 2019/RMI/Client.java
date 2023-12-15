package RMI;

import java.rmi.Naming;

public class Client {
    public static void main( String[] args) {

        try {
            CompteInterface account = (CompteInterface) Naming.lookup("rmi://localhost:2030/compte");
            account.debiter(300);
            account.crediter(700);
            System.out.println("Amount is : " + account.getSolde());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
