package Week5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class W5_Ex2_Server {
    public static void main(String[] args) {
        int port = 12345;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server đang đợi kết nối");
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " đã kết nối.");
            System.out.println("Local Address: " + socket.getLocalAddress());
            // Gắn kết input stream và output stream của socket
            BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // Nhận dữ liệu từ client
            String recv = "";

            while(!recv.equals("exit")){
                recv = inStream.readLine();
                System.out.println("Server đã nhận: " + recv);

                while (true) {
                    if(!recv.equals("exit")) {
                        // Đọc dữ liệu từ File với BufferedReader
                        if (recv.equals("hello")) {
                            outStream.write("Local Address: " + socket.getLocalAddress() + "\n");
                            outStream.flush();
                            outStream.write("Client public IP: " + socket.getRemoteSocketAddress() + "\n");
                            outStream.flush();
                            break;
                        }else {

                        }
                    }
                    else
                        outStream.write("Server đã đóng kết nối!\n");
                    outStream.flush();
                }
            }
            System.out.println("Server đã đóng kết nối!");
            socket.close();
            server.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
