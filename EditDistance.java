//EDIT DISTANCE
package Questions;
import java.util.Scanner;

public class EditDistance {

    public static int minEditDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // dp[i][j] = minimum edit distance between word1[0..i-1] and word2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Initialize base cases:
        // Converting empty string to word2 prefix and vice versa
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;  // delete all characters of word1 prefix
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;  // insert all characters of word2 prefix
        }

        // Fill dp table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no new operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Otherwise, consider the 3 operations and choose the minimum
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1],        // replace
                            Math.min(
                                    dp[i - 1][j],        // delete
                                    dp[i][j - 1]         // insert
                            )
                    );
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word1 = sc.nextLine().trim();
        String word2 = sc.nextLine().trim();

        int result = minEditDistance(word1, word2);
        System.out.println(result);

        sc.close();
    }
}
