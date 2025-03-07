package com.example;

import java.io.IOException;
import java.net.DatagramSocket;

public class Server extends Entrada {
   
    public static void main(String[] args) throws IOException {
        Hojas hojas = new Hojas(10); // Inicializar con 10 hojas
        try (DatagramSocket serverSocket = new DatagramSocket(PUERTO)) {
            System.out.println("🖥 Servidor UDP iniciado en el puerto " + PUERTO);

            // Iniciar el hilo para recibir mensajes
            Thread receptorThread = new Thread(new Receptor(serverSocket, hojas));
            receptorThread.start();

            // El servidor solo recibe, así que no necesita un bucle de envío
            receptorThread.join(); // Espera a que el hilo termine
        } catch (InterruptedException e) {
            System.err.println(" Error en el servidor: " + e.getMessage());
        }
    }
}
