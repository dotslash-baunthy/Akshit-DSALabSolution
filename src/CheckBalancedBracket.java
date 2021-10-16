import java.util.Scanner;
import java.util.Stack;

public class CheckBalancedBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the paranthesis string: ");
        String bracketString = scanner.nextLine();
        int result = checkBalance(bracketString);
        if (result == 1) {
            System.out.println("Balanced!");
        } else if (result == 0) {
            System.out.println("Not balanced!");
        } else {
            System.out.println("The string contained non-parenthesis elements!");
        }
    }

    // Return 1 if balanced
    // Return 0 if not balanced
    // Return -1 if the string accepted from the user contains non-parenthesis
    // elements
    private static int checkBalance(String bracketString) {
        // If the string has odd number of characters, it is unbalanced
        if (bracketString.length() % 2 == 1) {
            return 0;
        } else {
            Stack<Character> stack = new Stack<>();
            String closingBrackets = "}])";
            String openingBrackets = "{[(";
            for (int i = 0; i < bracketString.length(); i++) {
                char character = bracketString.charAt(i);
                // Push in stack if encoutered character in the string is an opening brace
                if (openingBrackets.indexOf(character) != -1) {
                    stack.push(character);
                }
                // Pop from stack if encountered character in the string is a closing brace and
                // compare the current character with the popped element
                else if (closingBrackets.indexOf(character) != -1) {
                    if (stack.isEmpty()) {
                        return 0;
                    } else {
                        char c = stack.pop();
                        switch (character) {
                            case '}':
                                if (c != '{') {
                                    return 0;
                                }
                                break;

                            case ']':
                                if (c != '[') {
                                    return 0;
                                }
                                break;

                            case ')':
                                if (c != '(') {
                                    return 0;
                                }
                                break;
                        }
                    }
                } else {
                    return -1;
                }
            }
        }
        return 1;
    }
}
