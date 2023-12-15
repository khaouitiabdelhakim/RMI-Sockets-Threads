import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Handling implements Runnable{
    Socket clientSocket;
    private static int amount = 1000;

    public Handling(Socket client) {
        this.clientSocket = client;
    }

    @Override
    public void run() {

            try (
                    ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())
            ) {
                while (true) {
                    // Receive request from client
                    String action = (String) in.readObject();
                    // Process client request
                    switch (action) {
                        case "getAmount":
                            out.writeObject(amount);
                            break;
                        case "+":
                            int addValue = (int) in.readObject();
                            amount += addValue;
                            out.writeObject(amount);
                            break;
                        case "-":
                            int subtractValue = (int) in.readObject();
                            amount -= subtractValue;
                            out.writeObject(amount);
                            break;
                        default:
                            System.out.println("Unknown action from client: " + action);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

    }
}
