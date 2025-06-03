package org.example.Nodo;

import java.util.*;

public class Nodo {
    private String valor;
    private List<Nodo> adyacentes;

    public Nodo(String valor) {
        this.valor = valor;
        this.adyacentes = new ArrayList<>();
    }

    public String getValor() {
        return valor;
    }

    public List<Nodo> getAdyacentes() {
        return adyacentes;
    }

    public void agregarAdyacente(Nodo nodo) {
        if (!adyacentes.contains(nodo)) {
            adyacentes.add(nodo);
        }
    }

    @Override
    public String toString() {
        return valor;
    }
}
