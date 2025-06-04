package org.example.Functions;

import org.example.Nodes.TreeNode;

public class Funciones {

    private TreeNode root;

    public Funciones() {
        this.root = null;
    }

    public void addLeaf(int value) {
        root = addLeafRec(root, value);
        System.out.println("Hoja insertada: " + value);
    }

    private TreeNode addLeafRec(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.getValue()) {
            root.setLeft(addLeafRec(root.getLeft(), value));
        } else {
            root.setRight(addLeafRec(root.getRight(), value));
        }
        return root;
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (value < root.getValue()) {
            return searchRec(root.getLeft(), value);
        } else if (value > root.getValue()) {
            return searchRec(root.getRight(), value);
        } else {
            return true;
        }
    }

    public void printTree() {
        System.out.println("\nÁrbol binario:");
        printTreeRec(root, "", true);
    }

    private void printTreeRec(TreeNode node, String prefix, boolean isRight) {
        if (node != null) {
            printTreeRec(node.getRight(), prefix + (isRight ? "        " : " |      "), true);

            System.out.println(prefix + (isRight ? " /----- " : " \\----- ") + node.getValue());

            printTreeRec(node.getLeft(), prefix + (isRight ? " |      " : "        "), false);
        }
    }
}
