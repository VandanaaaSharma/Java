import java.util.*;
public class Remove {
        class Node {
            int data;
            Node next;
            
            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        
        private Node head;
        private Node tail;
        public void addFirst(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }
        public int removeFirst() {
            if (head == null) {
                System.out.println("List is empty");
                return -1;
            }
            int val = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return val;
        }
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
        public static void main(String[] args) {
            Remove list = new Remove();
            list.addFirst(5);
            list.addFirst(4);
            list.addFirst(3);
            list.addFirst(2);
            list.addFirst(1);
            
            list.printList();
            System.out.println("Removed: " + list.removeFirst());
        list.printList();
        }

    }
    


