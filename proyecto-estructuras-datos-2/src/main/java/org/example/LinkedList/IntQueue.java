package org.example.LinkedList;

/**
 * Representa una cola de enteros implementada con una lista enlazada.
 * Permite insertar, eliminar y obtener elementos, así como mostrar
 * gráficamente la cola con un formato uniforme.
 */
public class IntQueue {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Inserta un nuevo elemento al final de la cola.
     *
     * @param value El valor entero a insertar.
     */
    public void insert(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Extrae el primer elemento de la cola.
     *
     * @return El valor del primer elemento o -1 si la cola está vacía.
     */
    private int extract() {
        if (head == null) return -1;
        int value = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return value;
    }

    /**
     * Elimina un elemento específico de la cola.
     *
     * @param value El valor del elemento a eliminar.
     * @return true si el elemento fue eliminado, false si no se encontró.
     */
    public boolean remove(int value) {
        if (head == null) return false;
        if (head.data == value) {
            extract();
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                if (current.next == tail) tail = current;
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Obtiene el primer elemento de la cola.
     *
     * @return El valor del primer elemento o -1 si la cola está vacía.
     */
    public int getFirst() {
        return (head != null) ? head.data : -1;
    }

    /**
     * Obtiene el último elemento de la cola.
     *
     * @return El valor del último elemento o -1 si la cola está vacía.
     */
    public int getLast() {
        return (tail != null) ? tail.data : -1;
    }

    /**
     * Obtiene el elemento en una posición específica de la cola.
     *
     * @param pos La posición del elemento (1-indexado).
     * @return El valor del elemento en la posición o -1 si la posición es inválida.
     */
    public int getAt(int pos) {
        if (pos < 1 || pos > size) return -1;
        Node current = head;
        for (int i = 1; i < pos; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Obtiene el tamaño actual de la cola.
     *
     * @return El número de elementos en la cola.
     */
    public int getSize() {
        return size;
    }

    /**
     * Imprime una representación gráfica de la cola con cajas.

     */
    public void printQueue() {
        final int boxWidth = 7;

        if (isEmpty()) {
            System.out.println("+-------+");
            System.out.println("|       | *");
            System.out.println("+-------+");
            return;
        }

        // Línea superior
        Node current = head;
        while (current != null) {
            System.out.print("+" + "-".repeat(boxWidth) + "+   ");
            current = current.next;
        }
        System.out.println();

        // Contenido centrado con flechas alineadas
        current = head;
        while (current != null) {
            String numStr = String.valueOf(current.data);
            int padding = boxWidth - numStr.length();
            int leftPad = padding / 2;
            int rightPad = padding - leftPad;

            if (current.next != null)
                System.out.print("|" + " ".repeat(leftPad) + numStr + " ".repeat(rightPad) + "|-->");
            else
                System.out.print("|" + " ".repeat(leftPad) + numStr + " ".repeat(rightPad) + "| * ");
            current = current.next;
        }
        System.out.println();

        // Línea inferior
        current = head;
        while (current != null) {
            System.out.print("+" + "-".repeat(boxWidth) + "+   ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Vacía la cola eliminando todos sus elementos.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }
}
