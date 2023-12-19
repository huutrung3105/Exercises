/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author nguyenhuutrung
 */
public class W1_Ex4 {
    public static void main(String[] args) {
        int n;
        int i=2,x=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n= ");
        n=sc.nextInt();
        System.out.print("Phân tích ra thừa số nguyên tố: "+n+" =");
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
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
            System.out.print(z + "^"+map.get(z)+"x");
        }
    }
    
}
