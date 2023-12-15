import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Serveur {

    private static Map<Socket, String> clientTokens = new HashMap<>();

    public static void main(String[] args) {
        ServerSocket serveur = null;
        try {
            serveur = new ServerSocket(2024);

            while (true) {
                Socket clientSocket = serveur.accept();
                System.out.println("Nouvelle demande interceptée ");



                // Générer un token unique basé sur le hash du temps actuel
                String token = generateToken();

                // Enregistrer le token associé au client
                clientTokens.put(clientSocket, token);

                // Créer un nouveau thread pour gérer la communication avec le client
                Thread clientThread = new Thread(new ClientHandler(clientSocket, token));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateToken() {
        // Utiliser le hash du temps actuel pour générer un token unique
        return String.valueOf(LocalDateTime.now().hashCode());
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;
        private String token;

        public ClientHandler(Socket clientSocket, String token) {
            this.clientSocket = clientSocket;
            this.token = token;
        }

        @Override
        public void run() {
            try {

                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                System.out.println("message recu:" + inputStream.read());

                // Envoyer le token au client
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                outputStream.writeObject(token);

                // Fermer les flux et la socket
                outputStream.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
