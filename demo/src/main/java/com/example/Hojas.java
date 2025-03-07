package com.example;

public class Hojas {
    private int hojasDisponibles;

    public Hojas(int numHojas) {
        this.hojasDisponibles = numHojas;
    }

    public synchronized boolean imprimir(int cantidad) {
        if (hojasDisponibles >= cantidad) {
            hojasDisponibles -= cantidad;
            return true; 
        }
        return false; 
    }

    public int getHojasDisponibles() {
        return hojasDisponibles;
    }
}
