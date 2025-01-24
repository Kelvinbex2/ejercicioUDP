package com.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
    private static final String LOCALHOST = "localhost";
    private static final int PUERTO = 8888;



    public static void enviar(String ms) throws IOException{
       
        DatagramSocket sSocket = new DatagramSocket();

        
        InetAddress equipo = InetAddress.getByName(LOCALHOST);
        
        byte[] mensaje = ms.getBytes();
        DatagramPacket msg = new DatagramPacket(mensaje,mensaje.length, equipo, PUERTO);
        
        sSocket.send(msg);
        sSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String msg = "";
        do {
            System.out.print(">");
             msg = sc.nextLine();
             
            enviar(msg);
            
        } while (!msg.equalsIgnoreCase("Salir"));
    }
    
}
