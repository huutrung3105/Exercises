package Week5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class W5_Ex3_Server {
    BufferedReader inStream; // Biến nhận dữ liệu từ stream socket
    BufferedWriter outStream; // Biến ghi dữ liệu vào stream socket
    ServerSocket server;
    Socket client;
    //test 12345
    static int INTERVAL = 10000;
    public W5_Ex3_Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Khởi tạo server thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean startServer() {
        try {
            client = server.accept();
            System.out.println("Client " + client.getRemoteSocketAddress() + " đã kết nối.");
            inStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outStream = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void closeSocket() throws IOException {
        inStream.close();
        outStream.close();
        client.close();
        server.close();
    }

    /**
     * Function nhận dữ liệu từ client -> gọi processData để xử lý. Vì dữ liệu từ server gửi về client nhiều dòng, nên từ khóa -END- được gửi vào cuối stream để báo hiệu client biết dữ liệu đã gửi hết.
     */
    private void handleClient() throws IOException {
        while (true) {
            String input = inStream.readLine();
            if (input.equals("bye")) {
                System.out.println("Server nhận được yêu cầu đóng kết nối từ client");
                outStream.write("Server nhận được yêu cầu đóng kết nối\n-END-\n");
                outStream.flush();
                break;
            }
            System.out.println("Server nhận được: " + input);
            String output = processData(input);
            outStream.write(output + "\n-END-\n");
            outStream.flush();
        }
        closeSocket();
    }

    private String processData(String input) {
        try {
            if ((Integer.parseInt(input))>1000000) {
                double rand_x, rand_y, origin_dist, pi=0;
                int circle_points = 0, square_points = 0;

                // Total Random numbers generated = possible x
                // values * possible y values
                for (int i = 0; i < (INTERVAL * INTERVAL); i++) {

                    // Randomly generated x and y values in the range [-1,1]
                    rand_x = Math.random()*2-1;
                    rand_y = Math.random()*2-1;

                    // Distance between (x, y) from the origin
                    origin_dist = rand_x * rand_x + rand_y * rand_y;

                    // Checking if (x, y) lies inside the define
                    // circle with R=1
                    if (origin_dist <= 1)
                        circle_points++;

                    // Total number of points generated
                    square_points++;

                    // estimated pi after this iteration
                    pi = ((4.0 * circle_points) / square_points);

                    // For visual understanding (Optional)
                    //System.out.println(rand_x+" "+rand_y+" "+circle_points+" "+square_points+" - "+pi);
                }
                return Double.toString(pi);
            }
            return "Vui lòng nhập n > 1.000.000 .";
        } catch (Exception e) {
            return "Vui lòng nhập n > 1.000.000 .";
        }
    }

    public static void main (String[] args) throws IOException {
        W5_Ex3_Server myserver = new W5_Ex3_Server(12345);
        if (!myserver.startServer()) {
            System.out.println("Lỗi không chấp nhận kết nối");
            return;
        }
        myserver.handleClient();
    }
}
