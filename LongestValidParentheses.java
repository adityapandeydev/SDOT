// LONGEST VALID PARENTHESES
package Questions;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.next();
        int len = longestValidParentheses(s);
        System.out.println("Longest valid parentheses length: " + len);
        sc.close();
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
