public class Transform {
    static class Node { // Make Node static
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree { // Make BinaryTree static
        Node root;

        // Function to calculate the sum of all nodes in the binary tree
        int sumBT(Node node) {
            if (node == null)
                return 0;
            return node.data + sumBT(node.left) + sumBT(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); // No need for an instance of Transform
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Sum of all nodes: " + tree.sumBT(tree.root));
    }
}
