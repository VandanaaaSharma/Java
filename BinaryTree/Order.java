import java.util.LinkedList;
import java.util.Queue;

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
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); // Keep track of levels
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");
                
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println(); // New line after each level
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, -1, -1, 3, -1, -1}; // Preorder representation
        Node root = BinaryTree.buildTree(nodes);
        
        System.out.println("Root Node: " + (root != null ? root.data : "null"));
        
        System.out.println("Preorder Traversal:");
        preOrder(root);
        System.out.println(); 

        System.out.println("Postorder Traversal:");
        postOrder(root);
        System.out.println(); 

        System.out.println("Level Order Traversal:");
        levelOrder(root);
    }
}