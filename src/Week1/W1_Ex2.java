package Week1;
import java.util.Scanner;
/**
 *
 * @author nguyenhuutrung
 */

public class W1_Ex2 {
 
    public static void main(String[] args) {
         
        int n;
        int sum = 0;
        Scanner sc;
        do {
            System.out.print("Nhập n = ");
            sc = new Scanner(System.in);
            n = sc.nextInt();
        }while(n <= 3);
         
        for(int i = 1; i <= n; i++) {
            if(n%i == 0) {
                sum += i;
            }
             
        }
        System.out.println("Tổng các ước số của " + n + ": " + sum);
        sc.close();
    }
}