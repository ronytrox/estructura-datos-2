package org.example;

import org.example.Nodo.Nodo;

import java.util.*;

public class GrafoNoDirigido {

    public static void main(String[] args) {

        Map<String, Nodo> nodos = new HashMap<>();
        Random random = new Random();

        for (char c = 'A'; c <= 'O'; c++) {
            String valor = String.valueOf(c);
            nodos.put(valor, new Nodo(valor));
        }

        List<String> claves = new ArrayList<>(nodos.keySet());

        for (String valor : claves) {
            Nodo nodoActual = nodos.get(valor);

            int cantidadAdyacentes = random.nextInt(3) + 2;

            for (int i = 0; i < cantidadAdyacentes; i++) {
                String aleatorio = claves.get(random.nextInt(claves.size()));


                Nodo adyacente = nodos.get(aleatorio);
                if (!nodoActual.getAdyacentes().contains(adyacente) && !nodoActual.equals(adyacente)) {
                    nodoActual.agregarAdyacente(adyacente);
                    adyacente.agregarAdyacente(nodoActual);
                }
            }
        }

        System.out.println("----- Lista de adyacencia del grafo -----");
        for (Nodo nodo : nodos.values()) {
            System.out.print(nodo.getValor() + " -> ");
            for (Nodo ady : nodo.getAdyacentes()) {
                System.out.print(ady.getValor() + " ");
            }
            System.out.println();
        }

    }
}