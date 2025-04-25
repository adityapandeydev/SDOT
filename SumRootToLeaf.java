// SUM ROOT TO LEAF NODES
package Questions;
import java.util.*;

public class SumRootToLeaf {

    // Binary Tree Node definition (static inner class)
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to build the tree from level-order input
    public static TreeNode buildTree(String[] elements) {
        if (elements.length == 0 || elements[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < elements.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!elements[index].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(elements[index]));
                queue.add(current.left);
            }
            index++;

            if (index >= elements.length) break;

            // Right child
            if (!elements[index].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(elements[index]));
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    // DFS to calculate root-to-leaf sums
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int currentNumber) {
        if (node == null) return 0;

        currentNumber = currentNumber * 10 + node.val;

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        // Otherwise, recurse left and right
        return dfs(node.left, currentNumber) + dfs(node.right, currentNumber);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine().trim();
        String[] nodes = inputLine.split("\\s+");

        TreeNode root = buildTree(nodes);
        int result = sumNumbers(root);
        System.out.println(result);
    }
}
