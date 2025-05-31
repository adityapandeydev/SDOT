// Permutations
package Questions;
import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input and parse integers
        String[] tokens = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }

        // Sort to ensure lexicographic order
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, results);

        // Print each permutation
        for (List<Integer> perm : results) {
            for (int num : perm) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void backtrack(int[] nums, List<Integer> current, boolean[] used,
                                 List<List<Integer>> results) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, current, used, results);

            // Backtrack
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
