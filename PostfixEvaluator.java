// EVALUATE POSTFIX EXPRESSION
package Questions;
import java.util.Stack;

public class PostfixEvaluator {
    // Evaluates a postfix expression where tokens are space-separated
    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = exp.split(" ");

        for (String token : tokens) {
            if (token.isEmpty())
                continue;
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();
                switch (token) {
                    case "+": stack.push(val1 + val2); break;
                    case "-": stack.push(val1 - val2); break;
                    case "*": stack.push(val1 * val2); break;
                    case "/": stack.push(val1 / val2); break;
                    case "%": stack.push(val1 % val2); break;
                    default: throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }
        return stack.pop();
    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    // Example usage
    public static void main(String[] args) {
        String expr = "5 3 4 * +";
        System.out.println(evaluatePostfix(expr)); // Output: 757
    }
}
