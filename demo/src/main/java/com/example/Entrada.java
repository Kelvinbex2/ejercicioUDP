package com.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Entrada {
    public static final String LOCALHOST = "localhost";
    public static final int PUERTO = 1111;
    public static final String MSG_FORMAT = "[%s:%s]: %s";

    // Método para enviar mensajes
    public static void enviar(String ms, DatagramSocket socket) throws IOException {
        InetAddress equipo = InetAddress.getByName(LOCALHOST);
        byte[] mensaje = ms.getBytes();
        DatagramPacket msg = new DatagramPacket(mensaje, mensaje.length, equipo, PUERTO);
        socket.send(msg);
    }

    // Método para recibir mensajes sin bloquear el puerto
    public static String recibir(DatagramSocket socket) throws IOException {
        byte[] buffer = new byte[1024]; 
        DatagramPacket msg = new DatagramPacket(buffer, buffer.length);
        socket.receive(msg);
        String datos = new String(msg.getData(), 0, msg.getLength()).trim();
        System.out.println(String.format(MSG_FORMAT, msg.getAddress(), msg.getPort(), datos));
        return datos;
    }
}
