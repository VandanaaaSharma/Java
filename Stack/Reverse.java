import java.util.Stack;

public class Reverse {

    // ✅ Add missing return type (void)
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return; // ✅ Added return to prevent unnecessary recursive calls
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return; // ✅ Base condition to stop infinite recursion
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void print(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop()); // ✅ Correct method call (s.pop())
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println("Original Stack:");
        print(s);

        // Refill stack for reversal
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        reverseStack(s);

        System.out.println("\nReversed Stack:");
        print(s);
    }
}
