package org.example.GUI;

import org.example.Functions.Funciones;

import java.util.Scanner;

public class Menu {

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        Funciones funciones = new Funciones();
        int opcion;

        do {
            println("\n--- MENÚ DE ÁRBOL BINARIO ---");
            println("1. Insertar una hoja");
            println("2. Buscar un valor");
            println("3. Imprimir el árbol");
            println("4. Salir");
            print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    print("Ingrese el valor a insertar: ");
                    int valorInsertar = scanner.nextInt();
                    funciones.addLeaf(valorInsertar);
                    break;
                case 2:
                    print("Ingrese el valor a buscar: ");
                    int valorBuscar = scanner.nextInt();
                    boolean encontrado = funciones.search(valorBuscar);
                    if (encontrado) {
                        println("✔ Valor encontrado en el árbol.");
                    } else {
                        println("✖ Valor no encontrado en el árbol.");
                    }
                    break;
                case 3:
                    funciones.printTree();
                    break;
                case 4:
                    println("Saliendo del programa...");
                    break;
                default:
                    println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
    }
}
