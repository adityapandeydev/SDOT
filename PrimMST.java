//Minimum Spanning Tree using Prim's Algorithm
package Questions;
import java.util.*;

public class PrimMST {

    // Function to find the vertex with minimum key value
    static int minKey(int[] key, boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to perform Prim's Algorithm and return total MST weight
    public static int primMST(int[][] graph, int V) {
        int[] key = new int[V];          // Weights to connect to MST
        boolean[] mstSet = new boolean[V]; // Included in MST

        Arrays.fill(key, Integer.MAX_VALUE); // Initialize all weights to infinity

        key[0] = 0; // Start from vertex 0
        int result = 0;

        for (int count = 0; count < V; count++) {
            int u = minKey(key, mstSet, V);  // Choose min key vertex not yet in MST
            mstSet[u] = true;

            if (key[u] != Integer.MAX_VALUE)
                result += key[u];

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }

        return result;
    }

    // Sample usage
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of vertices
        int V = sc.nextInt();

        // Read adjacency matrix
        int[][] G = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                G[i][j] = sc.nextInt();
            }
        }

        int mstWeight = primMST(G, V);
        System.out.println(mstWeight);
    }
}
