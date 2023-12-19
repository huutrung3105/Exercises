package Week4.Example;

import java.io.IOException;
import java.net.Socket;

public class Example1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("sgu.edu.vn", 443);
            if (socket.isConnected())
                System.out.println("Connected");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
