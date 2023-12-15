package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Compte extends UnicastRemoteObject implements CompteInterface {
    double montant;
    protected Compte(double montant) throws RemoteException {
        super();
        this.montant = montant;
    }

    @Override
    public void debiter(double montant) throws RemoteException {
        if (montant <= this.montant) {
            this.montant -= montant;
        }
    }

    @Override
    public void crediter(double montant) throws RemoteException {
        this.montant += montant;
    }

    @Override
    public double getSolde() throws RemoteException {
        return this.montant;
    }
}
