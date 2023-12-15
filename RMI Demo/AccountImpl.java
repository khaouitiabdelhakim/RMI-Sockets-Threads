import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccountImpl extends UnicastRemoteObject implements Account {
    float amount ;
    protected AccountImpl(float m) throws RemoteException {
        super();
        this.amount = m;
    }

    @Override
    public void changeAmount(float amount) throws RemoteException {
        this.amount += amount;
    }

    @Override
    public float getAmount() throws RemoteException {
        return this.amount;
    }

}

