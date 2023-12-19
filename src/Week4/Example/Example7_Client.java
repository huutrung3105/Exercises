package Week4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Example7_Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5001;
        try {
            Socket socket = new Socket(host, port);
            if(socket.isConnected())
                System.out.println("Connect successfully to server " + socket.getRemoteSocketAddress());
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
