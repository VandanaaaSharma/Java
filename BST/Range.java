public class Range {
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
    public static void printrange(Node root, int k1, int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printrange(root.left, k1, k2);
            System.out.println(root.data+"");
            printrange(root.right, k1, k2);
        } else if(root.data<k1){
            printrange(root.left, k1, k2);
        } else{
            printrange(root.right, k1, k2);
        }
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
        System.out.println("Nodes in range [3, 8]:");
        printrange(root, 3, 8);
}
}
