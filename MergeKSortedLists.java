//
package Questions;
import java.util.*;

public class MergeKSortedLists {

    // Helper class to store value, list index, and element index in the list
    static class Node {
        int val;
        int listIndex;  // Which list
        int elementIndex;  // Index in the list

        Node(int val, int listIndex, int elementIndex) {
            this.val = val;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt(); // number of lists
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();  // number of elements in list
            List<Integer> currentList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                currentList.add(sc.nextInt());
            }
            lists.add(currentList);
        }

        List<Integer> merged = mergeKLists(lists);

        // Print result
        for (int num : merged) {
            System.out.print(num + " ");
        }
    }

    // Merge using a min-heap (priority queue)
    private static List<Integer> mergeKLists(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<>();

        // Priority queue comparing nodes based on value
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        // Add the first element of each list to the heap
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new Node(lists.get(i).get(0), i, 0));
            }
        }

        // Process the heap
        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            result.add(current.val);

            // If there is a next element in the same list, add it to the heap
            int nextIndex = current.elementIndex + 1;
            if (nextIndex < lists.get(current.listIndex).size()) {
                int nextVal = lists.get(current.listIndex).get(nextIndex);
                minHeap.offer(new Node(nextVal, current.listIndex, nextIndex));
            }
        }

        return result;
    }
}

