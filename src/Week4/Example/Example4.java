package Week4;

import java.io.*;
import java.net.Socket;

public class Example4 {
    public static void main(String[] args) {
        String host = "whois.internic.net";
        int port = 43;
        try {
            Socket socket = new Socket(host, port);
            BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            outStream.write("thegioidecal.com\n");
            outStream.flush();
            // Đợi phản hồi từ server
            String resp;
            while((resp=inStream.readLine())!=null)
                System.out.println(resp);
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
