package org.example;

public class Reloj extends Thread{

    private int segundos = 0;

    public Reloj() {
        this.segundos = 0;
    }

    @Override
    public void run() {

        while(true){
            try {
                int horas = segundos / 3600;
                int minutos = (segundos % 3600) / 60;
                int segundosRestantes = segundos % 60;

                String tiempo = String.format("%02d:%02d:%02d", horas, minutos, segundosRestantes);

                System.out.print("\r Tiempo transcurrido: " + tiempo);

                System.out.flush();

                Thread.sleep(1000);
                segundos++;

            } catch (InterruptedException e) {
                System.out.println("El hilo fue interrumpido.");
                break; // Sale del bucle si el hilo es interrumpido
            }
        }
    }
}
