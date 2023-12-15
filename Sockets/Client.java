import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2023);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Example: Add 300 to the amount
            out.writeObject("+");
            out.writeObject(300);

            // Example: Subtract 700 from the amount
            out.writeObject("-");
            out.writeObject(700);

            // Example: Get current amount from server
            out.writeObject("getAmount");
            int currentAmount = (int) in.readObject();
            System.out.println("Current Amount on Server: " + currentAmount);

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



