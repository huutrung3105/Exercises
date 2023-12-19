package Week4;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Example6 {
    public static void main(String[] args) {
        String host = "thongtindaotao.sgu.edu.vn";
        int beginPort = 400;
        int endPort = 450;
        int timeout = 200;
        for (int port = beginPort; port <= endPort; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), timeout);
                System.out.println("Port " + port + " is opened");
            } catch (IOException e) {
                System.out.println("Port " + port + " is closed");
            }
        }

    }
}
