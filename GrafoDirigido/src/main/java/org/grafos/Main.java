package org.grafos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final double INFINITY = Double.MIN_VALUE;
    private static Map<String, Vertice> VerticeMap = new HashMap<String, Vertice>();
    public static Vertice vertice;
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in); // Para lectura desde consola.
        boolean n=true;
        while (n) {
            System.out.println("Ejemplo Grafo Dirigido!");
            System.out.println("1-Agregar Nodo");
            System.out.println("2-Agregar Arista");
            System.out.println("3-Imprimir Grafo");
            System.out.println("4-Fin");
            String s = scanner.next();
            switch (s)
            {
                case "1":{
                    System.out.println("Nodo: ");
                    String m = scanner.next();
                    Vertice v = new Vertice(m);
                    VerticeMap.put(m, v);
                    System.out.println("Nodo agregado: " + m);
                    break;
                }
                case  "2":{
                    System.out.println("Agregar Aristas");
                    System.out.println("Nodo origen: ");
                    String origen = scanner.next();
                    System.out.println("Nodo destino: ");
                    String destino = scanner.next();
                    System.out.println("Costo: ");
                    double costo = scanner.nextDouble();
                    AgregarArista(origen, destino, costo);
                    break;
                }

                case "3":{
                    System.out.println("Impresión del Arbol");
                    Imprimir();
                    break;
                }

                case "4":{
                    n=s=="4";
                    break;
                }
            }
        }

    }
    // Obtiene un vértice utilizando el nombre, sino lo agrega.
    private static Vertice getVertice(String nombre) {
        Vertice v = VerticeMap.get(nombre);
        if (v == null) {
            v = new Vertice(nombre);
        }
        return v;
    }

    // Agrega una arista al nodo.
    public static void AgregarArista(String nodoOrigen, String nodoDestino, double costo) {
        Vertice v = getVertice(nodoOrigen);
        Vertice w = getVertice(nodoDestino);
        v.adj.add(new Arista(w, costo));
    }

    public static void Imprimir() {
        for (Vertice v : VerticeMap.values()) {
            System.out.print(v.name + ": ");
            for (Arista a : v.adj) {
                System.out.print("-> " + a.dest.name + " (costo: " + a.cost + ") ");
            }
            for (Vertice v : VerticeMap.values()){

            }
            System.out.println();
        }
    }
}