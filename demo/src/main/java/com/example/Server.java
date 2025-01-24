package com.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Server {

    public static final int PUERTO = 8888;
    public static final String MSG= "[%s: " + "%s]: " + " %s";
    

    public static String recibir() throws IOException {
        DatagramSocket sSocket = new DatagramSocket(PUERTO);
        byte[] cadena = new byte[20];

        DatagramPacket msg = new DatagramPacket(cadena, cadena.length);

        sSocket.receive(msg);

        String datos = new String(msg.getData(), 0, msg.getLength());
        
        System.out.println(String.format(MSG, msg.getAddress(),sSocket.getLocalPort(),datos));

        sSocket.close();
        return datos;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            recibir();
        }
        
    }
}
