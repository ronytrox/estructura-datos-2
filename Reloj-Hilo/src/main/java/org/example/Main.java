package org.example;

public class Main {
    public static void main(String[] args) {
        Reloj reloj = new Reloj();
        reloj.start(); // Inicia el hilo del reloj

        try {
            reloj.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }
    }
}