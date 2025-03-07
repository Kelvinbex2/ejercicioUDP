package com.example;

import java.io.IOException;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Cliente extends Entrada {

    public static void main(String[] args) throws IOException {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            System.out.println("💻 Cliente UDP conectado.");

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Cliente > ");
                int msg = sc.nextInt();
                enviar(String.valueOf(msg), clientSocket);

                // Si el cliente quiere terminar, puede hacerlo.
                if (msg == 0) {  // Ejemplo de condición para terminar
                    System.out.println(" Cerrando cliente...");
                    break;
                }
            }
        }
    }
}
