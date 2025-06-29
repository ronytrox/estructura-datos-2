package org.example;

import org.example.LinkedList.IntQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase principal para interactuar con la cola de enteros mediante un menú.
 */
public class QueueProject {
    public static void main(String[] args) throws IOException {
        IntQueue queue = new IntQueue();
        boolean running = true;

        while (running) {
            print("\n===================================");
            print("            MENÚ PRINCIPAL         ");
            print("===================================");
            print("1. Insertar elemento");
            print("2. Extraer elemento");
            print("3. Obtener el primer elemento");
            print("4. Obtener el último elemento");
            print("5. Obtener elemento en posición");
            print("6. ¿La cola está vacía?");
            print("7. Tamaño actual de la cola");
            print("8. Mostrar todos los elementos de la cola");
            print("9. Vaciar cola");
            print("10. Terminar");
            print("===================================");

            int option = Integer.parseInt(read("Elige una opción: "));

            switch (option) {
                case 1:
                    int value = Integer.parseInt(read("Ingrese un número entero: "));
                    queue.insert(value);
                    break;
                case 2:
                    int toRemove = Integer.parseInt(read("Ingrese el elemento que desea eliminar: "));
                    boolean removed = queue.remove(toRemove);
                    if (removed)
                        print("Elemento eliminado: " + toRemove);
                    else
                        print("Elemento no encontrado en la cola.");
                    break;
                case 3:
                    int first = queue.getFirst();
                    if (first == -1)
                        print("La cola está vacía.");
                    else
                        print("Primer elemento: " + first);
                    break;
                case 4:
                    int last = queue.getLast();
                    if (last == -1)
                        print("La cola está vacía.");
                    else
                        print("Último elemento: " + last);
                    break;
                case 5:
                    int pos = Integer.parseInt(read("Ingrese la posición (1 a " + queue.getSize() + "): "));
                    int at = queue.getAt(pos);
                    if (at == -1)
                        print("Posición inválida.");
                    else
                        print("Elemento en posición " + pos + ": " + at);
                    break;
                case 6:
                    print(queue.isEmpty() ? "Sí" : "No");
                    break;
                case 7:
                    print("Tamaño actual de la cola: " + queue.getSize());
                    break;
                case 8:
                    queue.printQueue();
                    break;
                case 9:
                    queue.clear();
                    print("Cola vaciada.");
                    break;
                case 10:
                    running = false;
                    print("Programa terminado.");
                    break;
                default:
                    print("Opción no válida.");
            }
        }
    }

    /**
     * Imprime un mensaje en la consola.
     *
     * @param s El mensaje a imprimir.
     */
    static void print(Object s) {
        System.out.println(s);
    }

    /**
     * Lee una entrada del usuario desde la consola.
     *
     * @param s El mensaje que se muestra al usuario.
     * @return La entrada del usuario como cadena.
     * @throws IOException Si ocurre un error al leer la entrada.
     */
    static String read(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        print(s);
        return reader.readLine();
    }
}