import java.util.*;

public class StackUsingArrayList {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.isEmpty(); // Better than list.size() == 0
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException(); // Handle empty stack case
            }
            return list.remove(list.size() - 1);
        }

        public int peek() {
            if (isEmpty()) {
                throw new EmptyStackException(); // Handle empty stack case
            }
            return list.get(list.size() - 1);
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
