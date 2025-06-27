package org.example.LinkedList;

public class IntQueue {
    private Node head;
    private Node tail;
    private int size;

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

    private int extract() {
        if (head == null) return -1;
        int value = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return value;
    }

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

    public int getFirst() {
        return (head != null) ? head.data : -1;
    }

    public int getLast() {
        return (tail != null) ? tail.data : -1;
    }

    public int getAt(int pos) {
        if (pos < 1 || pos > size) return -1;
        Node current = head;
        for (int i = 1; i < pos; i++) {
            current = current.next;
        }
        return current.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("raíz -> *");
            return;
        }
        System.out.print("raíz -> ");
        Node current = head;
        while (current != null) {
            System.out.print("[ " + current.data + ", -> ");
            if (current.next == null) {
                System.out.print("*");
            }
            current = current.next;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(" ]");
        }
        System.out.println();
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }
}
