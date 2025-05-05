//TRAPPING RAIN WATER
package Questions;
import java.util.*;

public class MaxWaterContainer {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int ht = Math.min(height[left], height[right]);
            int area = width * ht;

            maxWater = Math.max(maxWater, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of lines
        int n = scanner.nextInt();
        int[] height = new int[n];

        // Read heights
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }

        int result = maxArea(height);
        System.out.println(result);
    }
}

