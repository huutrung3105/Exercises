/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 *
 * @author nguyenhuutrung
 */
public class W2_Ex1 {
    public static void main(String[] args) {
        var chuoi_pattern = "^\\d+([\\+\\-*\\/]\\d+)+$";
        String chuoi;
        while(true){
            System.out.print("Nhập vào chuỗi phép tính: ");
            Scanner sc = new Scanner (System.in);
            chuoi = sc.nextLine();
            if(chuoi.matches(chuoi_pattern)){
                break;
            }   
        }
        StringTokenizer st = new StringTokenizer(chuoi,"+-*/",true);
        int i = Integer.parseInt(st.nextToken());
        int result = i;
        while (st.hasMoreTokens()) {
            String op = st.nextToken();
            int i2 = Integer.parseInt(st.nextToken());
            switch (op) {
                case ("-"):
                    result-=i2;
                    break;
                case ("*"):
                    result*=i2;
                    break;
                case ("/"):
                    result/=i2;
                    break;
                case ("+"):
                    result+=i2;
                    break;
            }         
        }
        System.out.println("Kết quả của phép tính là: " + result);
    }
}