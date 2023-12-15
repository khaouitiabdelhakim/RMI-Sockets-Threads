import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Account extends Remote {

    void changeAmount(float amount) throws RemoteException ;

    float getAmount() throws RemoteException ;
}

