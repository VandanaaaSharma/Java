import java.util.*;
public class StackusingLL {
        static class Node {
            int data;
            Node next;
    
            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    
        static class Stack {
            private static Node head = null;
    
            public static boolean isEmpty() {
                return head == null;
            }
    
            public static void push(int data) {
                Node newNode = new Node(data); // ❌ ERROR: Cannot reference non-static class inside a static method.
                newNode.next = head;
                head = newNode;
            }
    
            public static int pop() {
                if (isEmpty()) {
                    System.out.println("Stack is empty");
                    return -1;
                }
                int top = head.data;
                head = head.next;
                return top;
            }
    
            public static int peek() {
                if (isEmpty()) {
                    System.out.println("Stack is empty");
                    return -1;
                }
                return head.data;
            }
        }
    
        public static void main(String[] args) {
            Stack s = new Stack();
            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);
            s.push(5);
    
            while (!s.isEmpty()) {
                System.out.println(s.peek());
                s.pop();
            }
        }
    }
    