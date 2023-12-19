package Week4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Example7_Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5001);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
