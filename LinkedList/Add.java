import java.util.*;

public class Add {
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
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            
        }
        tail.next=newNode;
        tail=newNode;
    }
    
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addMiddle(int idx, int data){
        Node newNode= new Node(data);
        Node temp = head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;

        }
        newNode.next=temp.next;
        temp.next=newNode;

    }
    
    public static void main(String[] args) {
        Add list = new Add();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(6);
        list.addLast(7);
        list.addMiddle(3,9);
        list.printList();
    }
}
