//Number of Substrings Containing All Three Characters
package Questions;
import java.util.Scanner;

public class SubstringWithAllABC {

    public static int numberOfSubstrings(String s) {
        int[] count = new int[3]; // index 0 → 'a', 1 → 'b', 2 → 'c'
        int i = 0, res = 0;

        for (int j = 0; j < s.length(); j++) {
            // Increase count for the current character
            count[s.charAt(j) - 'a']++;

            // While all characters are present
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += s.length() - j; // All substrings from i to end are valid
                count[s.charAt(i) - 'a']--; // Shrink from the left
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next(); 
        scanner.close();

        int result = numberOfSubstrings(s);
        System.out.println(result); 
    }
}
