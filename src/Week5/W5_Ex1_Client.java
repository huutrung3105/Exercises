package Week5;

import java.io.*;
import java.net.Socket;

public class W5_Ex1_Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;
        try {
            Socket socket = new Socket(host, port);
            // Gắn kết input stream và output stream của socket
            BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String input = "";
            while(!input.equals("exit")){
                // Nhận dữ liệu từ bàn phím -> socket qua output stream
                System.out.print("Nhập vào từ cần tra nghĩa: ");
                input = stdIn.readLine();
                outStream.write(input + "\n");
                outStream.flush();
                // Chờ nhận phản hồi từ server qua input stream
                String reply = inStream.readLine();
                System.out.println("Server phản hồi: " + reply);
            }
            System.out.println("Client đóng kết nối!");
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
