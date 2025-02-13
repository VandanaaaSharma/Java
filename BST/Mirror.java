class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Function to mirror the BST
    Node mirror(Node node) {
        if (node == null)
            return null;

        // Swap left and right subtrees
        Node temp = node.left;
        node.left = mirror(node.right);
        node.right = mirror(temp);

        return node;
    }

    // Inorder traversal of the tree
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Insert a node into BST
    Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("Inorder traversal of original BST:");
        tree.inorder(tree.root);
        
        tree.root = tree.mirror(tree.root);
        
        System.out.println("\nInorder traversal of mirrored BST:");
        tree.inorder(tree.root);
    }
}
