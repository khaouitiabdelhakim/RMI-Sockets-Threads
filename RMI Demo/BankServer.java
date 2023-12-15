import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BankServer {

    public static void main(String[] args)  {
        try {
            LocateRegistry.createRegistry(2023);
            AccountImpl account = new AccountImpl(1000);
            Naming.rebind("rmi://localhost:2023/monChat", account);
            System.out.println("BankServer is ready.");
        } catch (Exception e) {
            System.out.println("BankServer failed.\n" + e);
        }
    }
}
