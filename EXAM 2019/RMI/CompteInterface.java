package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CompteInterface extends Remote {
    void debiter(double montant) throws RemoteException;
    void crediter(double montant) throws RemoteException;
    double getSolde() throws RemoteException;
}
