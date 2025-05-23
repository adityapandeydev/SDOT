//LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
package Questions;
import java.util.*;

public class LongestUniqueSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char current = s.charAt(right);

            // Remove left-most characters until current character is not in the set
            while (seen.contains(current)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        int result = lengthOfLongestSubstring(input);
        System.out.println(result);
    }
}
