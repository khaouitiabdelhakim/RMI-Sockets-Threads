package Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

    public static void main(String[] args) {
        int port = 8182;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server waiting for client connection...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // Handling client request in a new thread
                new Thread(new HandleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleClient implements Runnable {
    Socket client;

    public HandleClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

    }
}
