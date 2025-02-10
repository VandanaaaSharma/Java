import java.util.ArrayList;

public class Root2leaf {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void printpath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("null"); // Indicating the end of a path
    }

    public static void roottoLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) { // Fix: Check if root is null, not root.data
            return;
        }
        
        path.add(root.data);

        // If it's a leaf node, print the path
        if (root.left == null && root.right == null) {
            printpath(path);
        } else {
            roottoLeaf(root.left, path);
            roottoLeaf(root.right, path);
        }

        // Backtracking step: remove last node after returning from recursion
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 5);
        root = insert(root, 3);
        root = insert(root, 7);
        root = insert(root, 2);
        root = insert(root, 4);
        root = insert(root, 6);
        root = insert(root, 8);

        ArrayList<Integer> path = new ArrayList<>();
        System.out.println("Root-to-Leaf Paths:");
        roottoLeaf(root, path);
    }
}
