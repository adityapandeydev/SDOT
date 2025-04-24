// DEPTH FIRST SEARCH OF GRAPH
package Questions;
import java.util.*;

public class DFSTraversal {

    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, List<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, result);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // Number of vertices
        int E = sc.nextInt(); // Number of edges

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // Since the graph is undirected
        }

        int start = sc.nextInt(); // Starting node

        // Optional: Sort the adjacency lists to ensure consistent order
        for (ArrayList<Integer> neighbors : adj) {
            Collections.sort(neighbors);
        }

        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();

        // Perform DFS
        dfs(start, visited, adj, result);

        // Print result
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
