// COMBINATION SUM
package Questions;
import java.util.*;

public class CombinationSum {

    public static void findCombinations(int[] candidates, int target, int index,
                                        List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;

            current.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i, current, result);  // Use same element
            current.remove(current.size() - 1);  // Backtrack
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());  // Number of elements
        int[] candidates = new int[n];

        String[] parts = sc.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            candidates[i] = Integer.parseInt(parts[i]);
        }

        int target = Integer.parseInt(sc.nextLine().trim());

        // Sort to ensure lexicographical order
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), result);

        for (List<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
