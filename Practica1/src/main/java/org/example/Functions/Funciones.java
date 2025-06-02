package org.example.Functions;

import org.example.Nodes.TreeNode;

public class Funciones {

    private static TreeNode root;

    public Funciones(){
        this.root = null;
    }

    public static void addLeaf(int value) {
        root = addLeafRec(root, value);
        System.out.println(root.toString());
    }

    private static TreeNode addLeafRec(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.getValue()) {
            root.setLeft(addLeafRec(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(addLeafRec(root.getRight(), value));
        }
        return root;
    }

    public int search(int value) {
        return searchRec(root, value);
    }

    private int searchRec(TreeNode root, int value) {
        if (root == null) {
            return -1; // Valor no encontrado
        }
        if (value < root.getValue()) {
            return searchRec(root.getLeft(), value);
        } else if (value > root.getValue()) {
            return searchRec(root.getRight(), value);
        } else {
            return root.getValue(); // Valor encontrado
        }
    }
}
