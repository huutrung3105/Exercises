/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author nguyenhuutrung
 */
public class W3_Ex2 {
    public static void main(String[] args) {
        String url = "/Users/nguyenhuutrung/NetBeansProjects/Exercises/src/Week3/W3_domain_name.txt";
        File file = new File(url);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    InetAddress inet = InetAddress.getByName(line);
                    System.out.println("Domain name " + line + " has IP " + inet.getHostAddress());
                } catch (IOException e) {
                    System.out.println("Could not find IP of domain name "+ line);
                }
                
            }
        } catch (FileNotFoundException e) {
            System.err.println( "Could not find "+ url);
        }
    }
}
