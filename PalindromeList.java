//PALINDROME OF A LIST
package Questions;
import java.util.*;

public class PalindromeList {

    public static boolean isPalindrome(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read length
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        // Read list values
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        // Check and print result
        System.out.println(isPalindrome(list));
    }
}
