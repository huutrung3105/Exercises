package Week4;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

public class W4_Ex4_Client {
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
                System.out.print("Mời bạn đoán số (n<=100): ");
                input = stdIn.readLine();
                outStream.write(input + "\n");
                outStream.flush();
                // Chờ nhận phản hồi từ server qua input stream
                String reply = inStream.readLine();
                if(reply.contains("Congratulation!!!")) {
                    StringTokenizer st = new StringTokenizer(reply, ";");
                    System.out.println(st.nextToken());
                    System.out.println("Bạn đã đoán " + st.nextToken() + " lần.");
                    long l = Long.parseLong(st.nextToken());
                    int h = (int) (l/1000/60/60);
                    int m = (int) ((l-h*60*60*1000)/60/1000);
                    int s = (int) (l-h*60*60*1000-m*60*1000)/1000;
                    System.out.println("Tổng thời gian đoán của bạn là: "+ h + " giờ " + m + " phút " + s + " giây");
                    break;
                } else {
                    System.out.println("Server phản hồi: " + reply);
                }
            }
            System.out.println("Client đóng kết nối!");
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
