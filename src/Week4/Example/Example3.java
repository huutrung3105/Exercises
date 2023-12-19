package Week4.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Example3 {
    public static void main(String[] args) {
        String host = "time.nist.gov";
        int port = 13;
        String resp;
        try {
            Socket socket = new Socket(host, port);
            BufferedReader inStream = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            while((resp = inStream.readLine())!=null)
                System.out.println(resp);
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
