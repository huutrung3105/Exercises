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
public class W3_Ex3 {
    public static void main(String[] args) {
        String filePath = "/Users/nguyenhuutrung/NetBeansProjects/Exercises/src/Week3/W3_IP.txt";
        File file = new File(filePath);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {                
                String line = sc.nextLine();
                try {
                    InetAddress inet = InetAddress.getByName(line);
                    if (inet.isReachable(2000)) {
                        System.out.println("IP "+line+ " is reachable.");
                    } else 
                        System.out.println("IP "+line+ " is NOT reachable.");
                } catch (IOException e) {
                    System.out.println("Invalid IP " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find " + filePath);
        }
    }
}
