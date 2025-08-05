package day10;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private List<Integer> values = new ArrayList<>();

    private final Node root;

    public static class Node {
        private Node leftChild = null;
        private Node rightChild = null;

        private final int value;

        @Override
        public String toString() {
            return "Node{" +
                   "leftChild=" + leftChild +
                   ", rightChild=" + rightChild +
                   ", value=" + value +
                   '}';
        }

        public Node(int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public int getValue() {
            return value;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    public BinarySearchTree(int value) {
        this.root = new Node(value);
    }

    public Node insert(int value) {
        return this.insert(this.root, value);
    }

    private Node insert(Node node, int value) {

        if (value < node.getValue()) {
            if (node.getLeftChild() == null) {
                Node newNode = new Node(value);
                node.setLeftChild(newNode);
                return newNode;
            } else {
                insert(node.getLeftChild(), value);
            }
        } else {
            if (node.getRightChild() == null) {
                Node newNode = new Node(value);
                node.setRightChild(newNode);
                return newNode;
            } else {
                insert(node.getRightChild(), value);
            }
        }

        return node;
    }

    public List<Integer> getAllValues() {
        values = new ArrayList<>();
        this.collectValues(root);
        return values;
    }

    private void collectValues(Node node) {
        if (node != null) {
            this.collectValues(node.getLeftChild());
            this.collectValues(node.getRightChild());
            values.add(node.getValue());
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
               "root=" + root +
               '}';
    }
}
