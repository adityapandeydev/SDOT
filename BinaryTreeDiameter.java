// Diameter of a Binary Tree
package Questions;
import java.util.*;

public class BinaryTreeDiameter {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Build binary tree from level-order input (with 'N' for null)
    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!nodes[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;
            if (i >= nodes.length) break;

            // Right child
            if (!nodes[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    // DFS function to compute diameter
    static int diameter = 0;
    public static int computeDiameter(TreeNode root) {
        diameter = 0;
        height(root);
        // "diameter" here is number of edges; question wants number of nodes, so add 1 if tree >1 node
        // But since in classic definitions, diameter = edges, and given sample expects "5" for the sample, which is edges not nodes+1.
        // So do not add 1 here
        return diameter;
    }

    // Helper to compute height and update diameter (global var)
    private static int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        diameter = Math.max(diameter, left + right + 1); // path is number of nodes
        return Math.max(left, right) + 1;
    }

    // Main method for input/output
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(nodes);

        int result = computeDiameter(root);
        System.out.println(result);
    }
}
