package com.example;

import java.io.IOException;
import java.net.DatagramSocket;

public class Receptor extends Entrada implements Runnable {
    private DatagramSocket socket;
    private Hojas hojas;

    public Receptor(DatagramSocket socket, Hojas jHojas) {
        this.socket = socket;
        this.hojas = jHojas;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String mensaje = recibir(socket); 

                // Validar que el mensaje es un número
                if (!mensaje.matches("\\d+")) {
                    System.out.println(" Mensaje inválido recibido: " + mensaje);
                    continue;
                }

                int cantidadSolicitada = Integer.parseInt(mensaje);
                
                
                if (hojas.imprimir(cantidadSolicitada)) {
                    System.out.println("Se imprimieron " + cantidadSolicitada + " hojas. Hojas restantes: " + hojas.getHojasDisponibles());
                } else {
                    System.out.println(" No hay suficientes hojas para imprimir " + cantidadSolicitada);
                }
            }
        } catch (IOException e) {
            System.err.println(" Error en la recepción: " + e.getMessage());
        }
    }
}
