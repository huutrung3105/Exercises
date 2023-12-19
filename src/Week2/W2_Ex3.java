/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author nguyenhuutrung
 */
public class W2_Ex3 {
    public static void main(String[] args) throws IOException {
        String url = "/Users/nguyenhuutrung/NetBeansProjects/Exercises/src/Week2/dictionary.txt";
        // Đọc dữ liệu từ File với BufferedReader
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Scanner sc = new Scanner(System.in);

        while (true) {            
            try {
                System.out.print("Nhập vào từ cần tra nghĩa: ");
                String tu = sc.nextLine();
                if (tu.equals("exit")) {
                    break;
                }
                fileInputStream = new FileInputStream(url);
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                while (line != null) {
                    StringTokenizer st = new StringTokenizer(line,";",false);
                    String a = st.nextToken();
                    if (tu.equals(a)) {
                        String yNghia = st.nextToken();
                        System.out.println("Từ bạn nhập có nghĩa là: "+ yNghia);
                        break;
                    } else {
                        line = bufferedReader.readLine(); 
                        if (line == null)
                            System.out.println("Từ bạn nhập không có trong từ điển! ");
                    }
                }
            } catch (FileNotFoundException ex) {
            System.err.println("Không tìm thấy file dictionary!");
            break;
            }
        }
        
    }
}
