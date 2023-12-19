package Week4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("ALL")
public class W4_Ex1_Server {
    public static void main(String[] args) {
        int port = 12345;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server đang đợi kết nối");
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " đã kết nối.");
            // Gắn kết input stream và output stream của socket
            BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // Nhận dữ liệu từ client
            String recv = "";
            while(!recv.equals("bye")){
                recv = inStream.readLine();
                System.out.println("Server đã nhận: " + recv);
                if(!recv.equals("bye")) {
                    StringBuilder str = new StringBuilder(recv);
                    outStream.write(str.reverse() + "\n");
                }
                else
                    outStream.write("Server đã đóng kết nối!\n");
                outStream.flush();
            }
            System.out.println("Server đã đóng kết nối!");
            socket.close();
            server.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
