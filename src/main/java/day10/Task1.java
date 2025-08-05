package day10;

public class Task1 {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree(20);

        tree.insert(10);
        tree.insert(5);
        tree.insert(7);
        tree.insert(18);

        System.out.println(tree.getAllValues());
        System.out.println(tree.getAllValues());


    }
}