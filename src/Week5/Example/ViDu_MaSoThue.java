package Week5.Example;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ViDu_MaSoThue {
    public static void main(String[] args){
        try{
            String cmnd = "300301302";
            String url = "https://masothue.com/Search/?q=" + cmnd + "&type=auto&force-search=1";
            String newURL = Jsoup.connect(url)
                    .method(Connection.Method.GET)
                    .followRedirects(true)
                    .execute()
                    .url().toString();
            // Kiểm tra CMND có thông tin không?
            if(newURL.equals(url)){
                System.out.println("Không có thông tin cá nhân");
            } else {
                Document doc = Jsoup.connect(newURL)
                        .method(Connection.Method.GET)
                        .execute()
                        .parse();
                String hoTen = doc.getElementsByTag("h1").first().text();
                String diaChi = doc.getElementsByAttributeValue("itemprop", "address").first().text();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
