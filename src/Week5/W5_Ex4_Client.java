package Week5;

import java.io.*;
import java.net.Socket;

public class W5_Ex4_Client {
    Socket socket;
    BufferedReader inStream, stdIn;
    BufferedWriter outStream;

    public static void main(String[] args) {
        W5_Ex4_Client client = new W5_Ex4_Client("localhost", 12345);
        client.handleData();
    }

    // Constructor của client
    public W5_Ex4_Client(String host, int port){
        try{
            socket = new Socket(host, port);
            System.out.println("Client đã kết nối đến server " + socket.getRemoteSocketAddress());
            // Gắn kết stream
            inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Phương thức đóng socket. Cần đóng theo thứ tự các biến gắn kết stream -> stream
    private void closeSocket(){
        try {
            stdIn.close();
            inStream.close();
            outStream.close();
            socket.close();
            System.out.println("Client đóng socket");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Phương thức xử lý dữ liệu nhận từ bàn phím -> stream -> server
    private void handleData(){
        try{
            while(true){
                // Nhận dữ liệu từ bàn phím (standard input)
                System.out.print("Nhập dữ liệu: ");
                String input = stdIn.readLine();
                // Ghi vào stream
                outStream.write(input + "\n");
                outStream.flush();
                // Chờ nhận dữ liệu từ server
                String data = inStream.readLine();
                do{
                    System.out.println("\t" + data);
                    data = inStream.readLine();
                }while(!data.equals("-END-"));
                // Xử lý nếu người dùng nhập chuỗi bye
                if(input.equals("bye"))
                    break;
            }
            closeSocket();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
