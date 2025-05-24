// HOUSE ROBBER
package Questions;
import java.util.*;

public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prev1 = 0; // Max if previous house was not robbed
        int prev2 = 0; // Max including before previous house

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().trim().split(",");

        int[] nums = Arrays.stream(parts)
                           .mapToInt(Integer::parseInt)
                           .toArray();

        int result = rob(nums);
        System.out.println(result);
    }
}
