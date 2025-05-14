//WILDCARD PATTERN MATCHING
package Questions;
import java.util.*;

public class WildcardMatcher {

    public static boolean isMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // dp[i][j] → whether text[0...i-1] matches pattern[0...j-1]
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true; // Empty pattern matches empty text

        // '*' can match empty string, so fill first row
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the rest of the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pc = pattern.charAt(j - 1);
                char tc = text.charAt(i - 1);

                if (pc == '?' || pc == tc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; // '*' as empty or multiple characters
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().trim();
        String pattern = sc.nextLine().trim();

        boolean result = isMatch(text, pattern);
        System.out.println(result);
    }
}


