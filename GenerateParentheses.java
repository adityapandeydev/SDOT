//GENERATE PARENTHESES
package Questions;
import java.util.*;

public class GenerateParentheses {

    // Backtracking function
    public static void generate(int n, int open, int close, StringBuilder current, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            generate(n, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }

        if (close < open) {
            current.append(')');
            generate(n, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }
    }

    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> combinations = generateParentheses(n);
        for (String s : combinations) {
            System.out.println(s);
        }
    }
}
