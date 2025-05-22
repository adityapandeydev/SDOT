//BINARY RIGHT SIDE VIEW
package Questions;
import java.util.*;

public class BTRightSideView {

    // Tree node definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to build a binary tree from a level order string
    static TreeNode buildTree(String[] nodes) {
        if (nodes[0].equals("N")) return null;

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

    // Function to return the right view
    static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Level order traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode rightMost = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                rightMost = node;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (rightMost != null) {
                result.add(rightMost.val);
            }
        }

        return result;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            TreeNode root = buildTree(arr);
            List<Integer> rightView = rightSideView(root);

            for (int val : rightView) {
                System.out.print(val + " ");
            }
            System.out.println(); // New line after each test case
        }
    }
}
