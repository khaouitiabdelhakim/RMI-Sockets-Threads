import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5555);
            System.out.println("Connecté au serveur.");
            // Flux de lecture et écriture pour la communication
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            // Affiche la demande du serveur pour le nom
            String demandeNom = scanner.nextLine();
            System.out.println(demandeNom);
            // Lit le nom depuis la console
            Scanner consoleScanner = new Scanner(System.in);
            String nom = consoleScanner.nextLine();
            // Envoie le nom au serveur
            writer.println(nom);
            // Affiche la demande du serveur pour l'âge
            String demandeAge = scanner.nextLine();
            System.out.println(demandeAge);
            // Lit l'âge depuis la console
            String age = consoleScanner.nextLine();
            // Envoie l'âge au serveur
            writer.println(age);
            // Fermeture des flux et de la socket
            scanner.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

