//SHORTEST PALINDROME
package Questions;
import java.util.*;

public class ShortestPalindrome {

    // Compute and return LPS (longest prefix suffix) array
    private static int computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[n - 1]; // Length of longest palindromic prefix
    }

    public static String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;

        int palinPrefixLength = computeLPS(combined);

        // Add the leftover part of reversed string to front of original
        String nonPalinSuffix = s.substring(palinPrefixLength);
        String prefixToAdd = new StringBuilder(nonPalinSuffix).reverse().toString();

        return prefixToAdd + s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        String result = shortestPalindrome(input);
        System.out.println(result);
    }
}
