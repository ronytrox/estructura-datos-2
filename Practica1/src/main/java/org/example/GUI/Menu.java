package org.example.GUI;

import org.example.Functions.Funciones;

public class Menu {
    public static void displayMenu() {
        println("Bienvenido a la inserción de datos en una estructura de árbol binario.");
        Funciones.addLeaf(4);
        Funciones.addLeaf(8);
        Funciones.addLeaf(12);
        Funciones.addLeaf(2);

    }
    
    
    private static void println(String message) {
        System.out.println(message);
    }
    
    private static void print(String message) {
        System.out.print(message);
    }
}
