package Week5;

import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class W5_Ex2_Server {
    BufferedReader inStream; // Biến nhận dữ liệu từ stream socket
    BufferedWriter outStream; // Biến ghi dữ liệu vào stream socket
    ServerSocket server;
    Socket client;
    //test
    public W5_Ex2_Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Khởi tạo server thành công.");
        } catch(IOException e){
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
            if (input.equals("hello")) {
                String returnData = "Private IP: " + server.getInetAddress().getHostAddress();
                // Đoạn code dưới đây lấy thêm Public IP bằng cách kết nối socket đến một địa chỉ bất kỳ
                Socket tmpSocket = new Socket("google.com", 443);
                returnData += "\nPublic IP: " + tmpSocket.getInetAddress().getHostAddress();
                return returnData;
            }
            if (input.split(" ")[0].equals("req")) {
                String url = "http://ip-api.com/json/" + input.split(" ")[1] + "?fields=status,message,continent,country,city";
                Document doc = Jsoup.connect(url)
                        .method(Connection.Method.GET)
                        .ignoreContentType(true)
                        .execute().parse();
                JSONObject ipinfo = new JSONObject(doc.text());
                if (ipinfo.get("status").equals("fail"))
                    return ipinfo.get("message").toString();
                String returnData = "Thông tin địa chỉ IP" + "\n + Châu lục: " + ipinfo.get("continent") + "\n + Quốc gia: "
                        + ipinfo.get("country") + "\n + Thành phố: " + ipinfo.get("city");
                return returnData;
            }
            return "Sai cú pháp. Vui lòng gửi yêu cầu dạng req x (x là địa chỉ IP cần tra).";
        } catch (Exception e) {
            return "Sai cú pháp. Vui lòng gửi yêu cầu dạng req x (x là địa chỉ IP cần tra).";
        }
    }

    public static void main(String[] args) throws IOException {
        W5_Ex2_Server myserver = new W5_Ex2_Server(12345);
        if (!myserver.startServer()) {
            System.out.println("Lỗi không chấp nhận kết nối");
            return;
        }
        myserver.handleClient();
    }
}