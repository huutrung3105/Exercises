package Week4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class W4_Ex2_Server {
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
                    int a = Integer.parseInt(recv);
                    if (ktraSoHH(a)){
                        outStream.write(a + " là số hoàn hảo.\n");
                    } else {
                        int b=a;
                        while (!ktraSoHH(b)) b += 1;
                        for (String s : Arrays.asList(a + " không phải là số hoàn hảo. ", b + " là số hoàn hảo lớn hơn và gần " + a + " nhất.\n")) {
                            outStream.write(s);
                        }
                    }
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
    public static boolean ktraSoHH(int a){
        int sum = 0;
        for(int i=1;i<=a/2;i++){
            if(a%i==0)
                //tổng các ước số của a
                sum+=i;
        }
        if (sum==a) return true;
        return false;
    }
}
