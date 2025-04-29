//NUMBER OF LONGEST INCREASING SUBSEQUENCES
package Questions;
import java.util.*;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // dp[i] = length of LIS ending at index i
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every element is LIS of length 1 by itself

        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input and split by comma
        String input = sc.nextLine().trim();
        String[] tokens = input.split(",");

        // Convert to integer array
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i].trim());
        }

        int result = lengthOfLIS(nums);
        System.out.println(result);
    }
}
