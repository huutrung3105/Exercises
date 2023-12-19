/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author nguyenhuutrung
 */
public class W3_Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {            
            System.out.println("Input a domain name: ");
            input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                InetAddress add=InetAddress.getByName(input);
                System.out.println("Domain name " + input + "has IP: " + add.getHostAddress());
            } catch (UnknownHostException e) {
                System.out.println("Could not find IP of domain " + input);
            }
        }
    }
}
