package org.grafos;

public class Arista {
    public Vertice dest; // Segundo vértice de la arista.
    public double cost; // Coste de la arista.

    public Arista(Vertice d, double c) {
        dest = d; // Segundo vértice de la arista
        cost = c; // Costo
    }
}

