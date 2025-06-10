package org.grafos;

import java.util.LinkedList;

public class Vertice
{
    public String name;
    public LinkedList<Arista> adj; // Vértices Adyacentes.
    public double dist; // Coste.
    public Vertice prev; // Vértice anterior.
    public int scratch;

    public Vertice (String  nm)
    {
        this.name = nm;
        this.adj = new LinkedList<Arista>();
        reset();
    }

    public void reset(){
        dist = Main.INFINITY;
        prev = null;
        scratch = 0;
    }
}
