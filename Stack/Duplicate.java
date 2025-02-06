import java.util.Stack;

public class Duplicate {

    public static boolean parentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If the character is an opening parenthesis
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If the character is a closing parenthesis
            else if (ch == ')' || ch == '}' || ch == ']') {
                // Check for duplicate parentheses (i.e., empty set of parentheses like ())
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), ch)) {
                    return false; // Mismatched parentheses or stack underflow
                }
                
                // Check if there are redundant parentheses
                if (stack.peek() == '(' || stack.peek() == '{' || stack.peek() == '[') {
                    return false; // Duplicate parentheses found
                }
                
                stack.pop(); // Pop matching opening parenthesis
            }
        }
        
        // If stack is empty, parentheses are valid, otherwise, invalid
        return stack.isEmpty();
    }

    // Helper function to check if a pair of parentheses match
    public static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }

    public static void main(String[] args) {
        System.out.println(parentheses("(){}[]"));  
        System.out.println(parentheses("([)]"));    
        System.out.println(parentheses("{[()]}"));  
        System.out.println(parentheses("((()))"));  
        System.out.println(parentheses("(()())"));  
        System.out.println(parentheses("()"));      
    }
}
