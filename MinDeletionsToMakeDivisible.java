//MINIMUM DELETIONS TO MAKE ARRAYS DIVISIBLE
package Questions;
import java.util.*;

public class MinDeletionsToMakeDivisible {

    // Function to calculate GCD
    private static int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // Function to calculate GCD of array
    private static int gcdArray(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = gcd(res, arr[i]);
        }
        return res;
    }

    public static int minDeletions(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);

        int targetGCD = gcdArray(numsDivide);

        for (int i = 0; i < nums.length; i++) {
            if (targetGCD % nums[i] == 0) {
                return i; // i deletions to get here
            }
        }

        return -1; // No valid element found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read nums
        String[] numStrs = sc.nextLine().trim().split("\\s+");
        int[] nums = Arrays.stream(numStrs).mapToInt(Integer::parseInt).toArray();

        // Read numsDivide
        String[] divStrs = sc.nextLine().trim().split("\\s+");
        int[] numsDivide = Arrays.stream(divStrs).mapToInt(Integer::parseInt).toArray();

        int result = minDeletions(nums, numsDivide);
        System.out.println(result);
    }
}

