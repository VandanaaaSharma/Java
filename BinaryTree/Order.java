public class Order {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // Corrected method: changed return type from int to void
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data); // Fixed output
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, -1, -1, 3, -1, -1}; // Corrected array syntax
        Node root = BinaryTree.buildTree(nodes);
        
        System.out.println("Root Node: " + (root != null ? root.data : "null"));
        
        // Corrected method call
        preOrder(root);
    }
}
