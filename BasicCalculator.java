// Basic Calculator
package Questions;

import java.util.*;

public class BasicCalculator {

    public static int evaluate(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        // Remove all spaces for easier parsing
        expression = expression.replaceAll("\\s+", "");
        int i = 0;

        while (i < expression.length()) {
            char ch = expression.charAt(i);

            // If digit, parse full number
            if (Character.isDigit(ch)) {
                int num = 0;

                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i++) - '0');
                }

                operands.push(num);
                continue; // 'i' is already incremented
            }

            // Opening parenthesis
            else if (ch == '(') {
                operators.push(ch);
            }

            // Closing parenthesis -> solve entire () block
            else if (ch == ')') {
                while (operators.peek() != '(') {
                    applyTopOperator(operands, operators);
                }
                operators.pop(); // Pop the '('
            }

            // Operator
            else if (isOperator(ch)) {
                // Apply previous operators while precedence is higher or equal
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    applyTopOperator(operands, operators);
                }
                operators.push(ch);
            }

            i++; // Move to next character
        }

        // Apply remaining operators
        while (!operators.isEmpty()) {
            applyTopOperator(operands, operators);
        }

        return operands.pop();
    }

    // Helper: check if valid operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Helper: apply top operator to top two operands
    private static void applyTopOperator(Stack<Integer> operands, Stack<Character> operators) {
        int b = operands.pop();
        int a = operands.pop();
        char op = operators.pop();

        switch (op) {
            case '+': operands.push(a + b); break;
            case '-': operands.push(a - b); break;
            case '*': operands.push(a * b); break;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                operands.push(a / b); break;
        }
    }

    // Helper: operator precedence
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        try {
            int result = evaluate(expression);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
