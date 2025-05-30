// Course Schedule
package Questions;
import java.util.*;

public class CourseSchedule {

    public static int canFinish(int N, List<int[]> prerequisites) {
        // Build adjacency list and indegree array
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[N];
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            adj.get(b).add(a);
            indegree[a]++;
        }

        // Kahn's algorithm for topological sorting
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++)
            if (indegree[i] == 0) queue.add(i);

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int next : adj.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.add(next);
            }
        }
        // If all courses can be taken, count==N
        return count == N ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        int M = Integer.parseInt(sc.nextLine().trim());
        List<int[]> prerequisites = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] pair = sc.nextLine().trim().split("\\s+");
            prerequisites.add(new int[]{Integer.parseInt(pair[0]), Integer.parseInt(pair[1])});
        }
        System.out.println(canFinish(N, prerequisites));
    }
}
