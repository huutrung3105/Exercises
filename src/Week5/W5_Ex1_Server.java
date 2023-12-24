package Week5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class W5_Ex1_Server {
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
            String url = "/Users/nguyenhuutrung/NetBeansProjects/Exercises/src/Week5/dictionary.txt";
            FileInputStream fileInputStream;
            BufferedReader bufferedReader;

            while(!recv.equals("exit")){
                recv = inStream.readLine();
                System.out.println("Server đã nhận: " + recv);

                if(!recv.equals("exit")) {
                    // Đọc dữ liệu từ File với BufferedReader
                    try {
                        fileInputStream = new FileInputStream(url);
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        String line = bufferedReader.readLine();
                        while (line != null) {
                            StringTokenizer st = new StringTokenizer(line,";",false);
                            String a = st.nextToken();
                            if (recv.equals(a)) {
                                String yNghia = st.nextToken();
                                outStream.write("Từ bạn nhập có nghĩa là: "+ yNghia + "\n");
                                break;
                            } else {
                                line = bufferedReader.readLine();
                                if (line == null)
                                    outStream.write("Từ bạn nhập không có trong từ điển! \n");
                            }
                        }
                    } catch (FileNotFoundException ex) {
                        outStream.write("Không tìm thấy file dictionary! \n" );
                        break;
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
}
