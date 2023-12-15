package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            System.out.println("Serveur : Construction de l’implémentation");
            Compte cpt= new Compte(2000.0);
            System.out.println("Objet Compte enregistré dans RMIregistry");
            // à compléter
            LocateRegistry.createRegistry(2030);
            Naming.rebind("rmi://localhost:2030/compte",cpt);

            System.out.println("Attente des invocations des clients ");
        } catch (Exception e) {
            System.out.println("Erreur de liaison de l'objet Compte");
            System.out.println(e.toString());
        } // fin du main
    }
}
