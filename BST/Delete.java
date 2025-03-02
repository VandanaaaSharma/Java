import org.w3c.dom.Node;

public class Delete {
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
        public static Node delete1(Node root, int val) {
            if (root == null) {  // Fix: Null check should be on root, not root.data
                return null;
            }
            else if(root.data>val){
                root.left=delete1(root.left, val);
            } else{
                //case1 No child
                if(root.left==null && root.right==null){
                    return null;
                }
                // case2 one child
                if(root.left==null){
                    return root.right;
                } else if(root.right==null){
                    return root.left;
                }
                Node IS=inorderSuccessor(root.right);
                root.data=IS.data;
                root.right=delete1(root.right,val);
            }
            return root;
        }
        public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
        public static Node inorderSuccessor(Node root){
            while(root.left!=null){
                root=root.left;
            }
            return root;
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
    
            System.out.println("Before deletion:");
            inorder(root);
            
            root = delete1(root, 7); // Fix: Call delete1 correctly
    
            System.out.println("\nAfter deletion:");
            inorder(root);
        }
    }