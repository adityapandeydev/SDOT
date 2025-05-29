// Number of Islands
package Questions;
import java.util.*;

public class DistinctIslandsWithSymmetry {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;

    // Directions: up, down, left, right
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static List<int[]> cells;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    cells = new ArrayList<>();
                    dfs(i, j, i, j);
                    shapes.add(canonical(cells));
                }
            }
        }

        System.out.println(shapes.size());
    }

    // DFS collecting coordinates relative to (originX, originY)
    static void dfs(int r, int c, int originX, int originY) {
        visited[r][c] = true;
        cells.add(new int[]{r - originX, c - originY});

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr >= 0 && nc >= 0 && nr < n && nc < m &&
                grid[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc, originX, originY);
            }
        }
    }

    // Generate canonical form under all 8 symmetries of the square
    static String canonical(List<int[]> shape) {
        List<String> forms = new ArrayList<>();
        int[][] transforms = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        for (int[] t : transforms) {
            List<int[]> one = new ArrayList<>();
            List<int[]> two = new ArrayList<>();
            for (int[] p : shape) {
                int x = p[0], y = p[1];
                one.add(new int[]{x * t[0], y * t[1]});
                two.add(new int[]{y * t[1], x * t[0]});
            }
            forms.add(normalize(one));
            forms.add(normalize(two));
        }

        Collections.sort(forms);
        return forms.get(0);
    }

    // Normalize: shift to (0,0) and flatten to string
    static String normalize(List<int[]> shape) {
        Collections.sort(shape, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int ox = shape.get(0)[0], oy = shape.get(0)[1];
        StringBuilder sb = new StringBuilder();
        for (int[] p : shape) {
            sb.append((p[0] - ox) + ":" + (p[1] - oy) + ";");
        }
        return sb.toString();
    }
}
