/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3;

import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author nguyenhuutrung
 */
public class W3_Ex4 {
    public static void main(String[] args) throws Exception {
        String privateIP;
        try (Socket socket = new Socket("google.com", 443)) {
            privateIP = socket.getLocalAddress().toString().split("/")[1];
        }
        String[] bytes = privateIP.split("\\.");
        String networkID = bytes[0] + "." + bytes[1] + "." + bytes[2] + ".";
        for (int i = 1; i < 255; i++) {
            InetAddress inet = InetAddress.getByName(networkID + i);
            if (inet.isReachable(1000)) {
                System.out.println("=>" + inet.getHostAddress() + " is reachable");
            } else
                System.out.println("=>" + inet.getHostAddress() + " is NOT reachable");
        }
    }
}
