//Spiral Matrix
package Questions;
import java.util.*;

class Main {
    public static void spiralOrder(int[][] matrix, int m, int n) {
        List<Integer> list = new ArrayList<>();
        // if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        //     return list;
        int top = 0, left = 0;
        int bottom = matrix.length - 1, right = matrix[0].length - 1;
        while(top <= bottom && left <= right) {
            int i;
            for (i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (i = top; i <= bottom; i++)
                list.add(matrix[i][right]);
            right--;
            if (top <= bottom) {
                for (i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        spiralOrder(matrix, m, n);
        sc.close();
    }
}