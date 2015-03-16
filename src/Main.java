import java.util.NoSuchElementException;

/**
 * Created by Xu on 3/14/2015.
 */
public class Main {
    public static void main (String[] args) {

        // 1. Insert a node use insertNode method in TriTree
        // 2. Delete a node use deleteNode method in TriTree
        // Node is defined in Node.java
        Node<Integer> n1 = new Node<Integer>(8);
        Node<Integer> n2 = new Node<Integer>(8);
        Node<Integer> n3 = new Node<Integer>(7);
        Node<Integer> n4 = new Node<Integer>(10);
        Node<Integer> n5 = new Node<Integer>(9);
        Node<Integer> n6 = new Node<Integer>(14);
        Node<Integer> n7 = new Node<Integer>(11);
        Node<Integer> n8 = new Node<Integer>(15);
        Node<Integer> n9 = new Node<Integer>(6);
        Node<Integer> n10 = new Node<Integer>(12);
        Node<Integer> n11 = new Node<Integer>(16);
        Node<Integer> n12 = new Node<Integer>(3);
        Node<Integer> n13 = new Node<Integer>(4);
        Node<Integer> n14 = new Node<Integer>(1);

        TriTree triTree = new TriTree();
        triTree.insertNode(null, n2);
        //triTree.insertNode(n3, n2);
        //triTree.insertNode(n5, n2);
        triTree.insertNode(n3, n2);
        //triTree.insertNode(n1, n2);
        triTree.insertNode(n4, n2);
        triTree.insertNode(n5, n2);
        triTree.insertNode(n6, n2);
        triTree.insertNode(n7, n2);
        triTree.insertNode(n8, n2);
        triTree.insertNode(n9, n2);
        triTree.insertNode(n10, n2);
        triTree.insertNode(n11, n2);
        triTree.insertNode(n12, n2);
        triTree.insertNode(n13, n2);
        triTree.insertNode(n14, n2);
        Node root;
        try {
            root = triTree.deleteNode(new Node<Integer>(8), n2);
            root = triTree.deleteNode(new Node<Integer>(14), n2);
            root = triTree.deleteNode(new Node<Integer>(15), n2);
//        root = triTree.deleteNode(new Node<Integer>(12), n2);
//        root = triTree.deleteNode(new Node<Integer>(11), n2);
//        root = triTree.deleteNode(new Node<Integer>(6), n2);
//        root = triTree.deleteNode(new Node<Integer>(7), n2);
//        root = triTree.deleteNode(new Node<Integer>(15), n2);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("No such element in the tree");
        }
        return;
    }
}
