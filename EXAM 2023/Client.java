import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Adresse IP du serveur
        int serverPort = 12345;

        try {
            // Se connecter au serveur
            Socket socket = new Socket(serverAddress, serverPort);

            // Recevoir le token du serveur
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String token = (String) inputStream.readObject();
            System.out.println("Token reçu du serveur: " + token);

            // Fermer les flux et la socket
            inputStream.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
