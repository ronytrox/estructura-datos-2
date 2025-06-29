package org.example.LinkedList;

/**
 * Representa un nodo en una lista enlazada.
 */
public class Node {
    int data;
    Node next;

    /**
     * Crea un nuevo nodo con el valor especificado.
     *
     * @param data El valor entero del nodo.
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}