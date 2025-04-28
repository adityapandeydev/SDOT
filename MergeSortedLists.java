// MERGE TWO SORTED LISTS
package Questions;
import java.util.*;

public class MergeSortedLists {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read first list
        int n = sc.nextInt();
        List<Integer> first = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            first.add(sc.nextInt());
        }

        // Read second list
        int m = sc.nextInt();
        List<Integer> second = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            second.add(sc.nextInt());
        }

        // Merge both sorted lists
        List<Integer> merged = mergeSortedLists(first, second);

        // Print merged list
        for (int num : merged) {
            System.out.print(num + " ");
        }
    }

    // Merge two sorted lists using two-pointer technique
    private static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        // Compare elements and add the smaller one
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements
        while (i < list1.size()) {
            result.add(list1.get(i++));
        }
        while (j < list2.size()) {
            result.add(list2.get(j++));
        }

        return result;
    }
}