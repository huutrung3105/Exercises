package Week4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class W4_Ex4_Server {
    public static void main(String[] args) {
        int port = 12345;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server đang đợi kết nối");
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " đã kết nối.");
            //server tạo ngẫu nhiên một số ranNum<=100
            int ranNum = ThreadLocalRandom.current().nextInt(1,101);
            System.out.println("Số ngẫu nhiên là: " + ranNum);
            // Gắn kết input stream và output stream của socket
            BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // Nhận dữ liệu từ client
            String recv = "";
            int guessnum = 0;
            int dem = 0;
            long start, end;

            while(!recv.equals("exit")&&guessnum!=ranNum){
                recv = inStream.readLine();
                guessnum = Integer.parseInt(recv);
                System.out.println("Server đã nhận: " + recv);
                start = System.currentTimeMillis();
                System.out.println(start);
                if(!recv.equals("exit")) {
                    while (guessnum != ranNum) {
                        if (guessnum>ranNum) {
                            outStream.write("Số bạn đoán lớn hơn n. \n");
                            dem ++;
                            outStream.flush();
                            recv = inStream.readLine();
                            guessnum = Integer.parseInt(recv);
                            System.out.println("Server đã nhận: " + recv);
                        } else {
                            outStream.write("Số bạn đoán nhỏ hơn n. \n");
                            dem++;
                            outStream.flush();
                            recv = inStream.readLine();
                            guessnum = Integer.parseInt(recv);
                            System.out.println("Server đã nhận: " + recv);
                        }
                    }
                    end = System.currentTimeMillis();
                    System.out.println(end);
                    outStream.write("Congratulation!!! ;" + dem + ";" + (end-start));
                    outStream.flush();
                    break;
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