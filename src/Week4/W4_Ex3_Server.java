package Week4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class W4_Ex3_Server {
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
            while(!recv.equals("exit")){
                recv = inStream.readLine();
                System.out.println("Server đã nhận: " +recv);
                if(!recv.equals("exit")) {
                    int n = Integer.parseInt(recv), i = 2, x = 0;
                    outStream.write("Phân tích ra thừa số nguyên tố: "+n+" =");
                    Map<Integer, Integer> map = new HashMap<>();
                    while (n>=1) {
                        if (n%i==0) {
                            n=n/i;
                            x++;
                        } else {
                            if (x>0) {
                                map.put(i,x);
                                i++;
                                x=0;
                            } else i++;
                        }
                    }
                    for (Integer z: map.keySet()) {
                        outStream.write(z + "^"+map.get(z)+"x");
                    }
                    outStream.write("\n");
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
