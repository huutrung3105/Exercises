package Week1;

import java.util.Scanner;

/**
 *
 * @author nguyenhuutrung
 */

public class W1_Ex1 {
    public static void main(String[] args) {
        int num, sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào n: ");
        num = sc.nextInt();
        for(int i = 1; i <= num; ++i)
        {
            // sum = sum + i;
            sum += i;
        }
        System.out.println("Tổng các số tự nhiên từ 1 đến "+ num +" là: "+sum);
    }
}