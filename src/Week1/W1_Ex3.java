package Week1;
import java.util.Scanner;
/**
 *
 * @author nguyenhuutrung
 */

public class W1_Ex3 {
 
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
            if(isPrimeNumber(i)) {
                sum += i;
            }
             
        }
        
        System.out.println("Tổng các số nguyên tố <  " + n + ": " + sum);
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