// 0-1 KNAPSACK ALGORITHM
package Questions;
import java.util.*;

public class ZeroOneKnapsack {

    public static int knapsack(int N, int W, int[] weight, int[] value) {
        // dp[i][w] -> max value for first i items with capacity w
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    // Max of including or excluding current item
                    dp[i][w] = Math.max(
                        dp[i - 1][w],                             // Exclude
                        dp[i - 1][w - weight[i - 1]] + value[i - 1] // Include
                    );
                } else {
                    dp[i][w] = dp[i - 1][w]; // Can't include item
                }
            }
        }

        return dp[N][W]; // Max value at full capacity using all items
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];

        for (int i = 0; i < N; i++) weight[i] = sc.nextInt();
        for (int i = 0; i < N; i++) value[i] = sc.nextInt();

        System.out.println(knapsack(N, W, weight, value));
    }
}
