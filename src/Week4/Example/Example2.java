package Week4.Example;

import java.io.IOException;
import java.net.Socket;

public class Example2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("sgu.edu.vn", 443);
            System.out.println("Connect to " + socket.getInetAddress() + ":" 
            + socket.getPort() + " from local port " + socket.getLocalPort() + 
            " of local IP " + socket.getLocalAddress());
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
