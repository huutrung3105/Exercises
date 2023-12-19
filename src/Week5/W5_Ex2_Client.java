package Week5;

import java.io.*;
import java.net.Socket;

public class W5_Ex2_Client {
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
            String pattern = "/\\breq (?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b/";
            while(!input.equals("exit")){
                // Nhận dữ liệu từ bàn phím -> socket qua output stream
                while(!input.equals("hello")) {
                    System.out.println("Tra thông tin server: hello");
                    System.out.println("Tra cứu IP (x là một địa chỉ IP public): req x");
                    System.out.print("Mời bạn nhập theo hướng dẫn: ");
                    input = stdIn.readLine();
                    if (pattern.matches(input)) break;
                }
                outStream.write(input + "\n");
                outStream.flush();
                // Chờ nhaận phản hồi từ server qua input stream
                while (!inStream.lines().equals("")) {
                    String reply = inStream.readLine();
                    System.out.println("Server phản hồi: " + reply);
                }
                System.out.println("test thử dòng này");
                input = "";
            }
            System.out.println("Client đóng kết nối!");
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
