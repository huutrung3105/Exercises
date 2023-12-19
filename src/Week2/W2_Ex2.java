/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author nguyenhuutrung
 */
public class W2_Ex2 {
    public static void main(String[] args) {
//        System.out.println("Nhập vào chuỗi: ");
//        Scanner sc = new Scanner(System.in);
//        String chuoi = sc.nextLine();
//        System.out.println(chuoi);
        String chuoi = "Dai hoc sai gon la mot trong nhung    truong dai hoc lau doi nhat sai gon";
        StringTokenizer st = new StringTokenizer(chuoi, " ");
        LinkedHashMap<String,String>map = new LinkedHashMap<>();
        while (st.hasMoreTokens()) {
            String value = st.nextToken();
            String key = value.toLowerCase();
            map.putIfAbsent(key, value);
        }
        StringBuilder output = new StringBuilder();
        map.forEach(((key, value) -> {
            output.append(value).append(" ");
        }));
        System.out.println(output);
    }
}
