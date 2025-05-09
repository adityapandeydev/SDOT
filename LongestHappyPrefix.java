// Longest Happy Prefix
package Questions;
import java.util.*;

public class LongestHappyPrefix {

    public static String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0; // length of the previous longest prefix suffix

        // Build the LPS array
        for (int i = 1; i < n; i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }

            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
            }
        }

        int longest = lps[n - 1]; // Longest prefix also a suffix (excluding full string)

        return s.substring(0, longest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        String result = longestPrefix(input);
        System.out.println(result);
    }
}
