package Week4;

import java.io.*;
import java.net.Socket;

public class Example5 {
    public static void main(String[] args) {
        String host = "thongtindaotao.sgu.edu.vn";
        int port = 80;
        try {
            Socket socket = new Socket(host, port);
            BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            outStream.write("GET / HTTP/1.1" + "\r\n");
            outStream.write("Host: " + host + "\r\n");
            outStream.write("\r\n");
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
