//MINIMUM FUEL COST TO REPORT TO THE CAPITAL
package Questions;
import java.util.*;

public class MinimumFuelCostToCapital {

    static long totalFuel = 0;
    static int seats;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read roads as a single line, split by ","
        String[] roadPairs = sc.nextLine().trim().split(",");
        List<int[]> roads = new ArrayList<>();
        int n = 0;

        for (String pair : roadPairs) {
            String[] cities = pair.trim().split("\\s+");
            int u = Integer.parseInt(cities[0]);
            int v = Integer.parseInt(cities[1]);
            roads.add(new int[]{u, v});
            n = Math.max(n, Math.max(u, v) + 1);
        }

        seats = Integer.parseInt(sc.nextLine().trim());

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        // DFS traversal to calculate fuel cost; node 0 is the capital
        dfs(0, -1, graph);

        System.out.println(totalFuel);
    }

    // Returns the number of people (representatives) in subtree rooted at 'node'
    private static int dfs(int node, int parent, List<List<Integer>> graph) {
        int people = 1; // Each city has one representative

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            people += dfs(neighbor, node, graph);
        }

        // Don't count the capital's road up, and nothing to add up for capital
        if (node != 0) {
            // Calculate number of car trips needed (ceil division)
            totalFuel += (people + seats - 1) / seats;
        }

        return people;
    }
}
