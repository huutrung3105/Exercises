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
public class W1_Ex5 {
    public static void main(String args[]) {
        int n;
        Scanner sc;
        do {
            System.out.print("Nhập n = ");
            sc = new Scanner(System.in);
            n = sc.nextInt();
        } while(n <= 3);
        //bai1
        int sum1=0;
        for(int i = 1; i <= n; ++i)
        {
            sum1 += i;
        }
        System.out.println("Tổng các số tự nhiên từ 1 đến "+ n +" là: "+sum1);
        //bai2
        int sum2=0;
        for(int i = 1; i <= n; i++) {
            if(n%i == 0) {
                sum2 += i;
            } 
        }
        System.out.println("Tổng các ước số của " + n + ": " + sum2);
        //bai3
        int sum3=0;
        for(int i = 1; i <= n; i++) {
            if(isPrimeNumber(i)) {
                sum3 += i;
            }  
        }
        System.out.println("Tổng các ước số của " + n + ": " + sum3);
        //bai4
        int i=2,x=0;
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
        sc.close();
    }
    public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}