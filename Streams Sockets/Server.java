import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serveurSocket = new ServerSocket(5555);
            System.out.println("Serveur en attente de connexions...");

           while(true) {
               // Attend une connexion
               Socket clientSocket = serveurSocket.accept();
               System.out.println("Client connecté.");

               // Flux de lecture et écriture pour la communication
               Scanner scanner = new Scanner(clientSocket.getInputStream());
               PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

               // Demande le nom
               writer.println("Quel est votre nom ?");
               String nom = scanner.nextLine();
               System.out.println("Nom reçu du client : " + nom);

               // Demande l'âge
               writer.println("Quel est votre âge ?");
               String age = scanner.nextLine();
               System.out.println("Âge reçu du client : " + age);

               // Fermeture des flux et des sockets
               scanner.close();
               writer.close();
               clientSocket.close();
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

