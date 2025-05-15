// KTH SMALLEST ELEMENT IN A BST
package Questions;
import java.util.*;

public class KthSmallestInBST {

    // Tree node class
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to build tree from level-order input
    public static TreeNode buildTree(String[] data) {
        if (data.length == 0 || data[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < data.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!data[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(data[i]));
                current.left = left;
                queue.offer(left);
            }
            i++;
            if (i >= data.length) break;

            // Right child
            if (!data[i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(data[i]));
                current.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }

    static int count = 0;
    static int kthValue = -1;

    // In-order traversal to find kth smallest
    public static void inOrder(TreeNode node, int k) {
        if (node == null || kthValue != -1) return;

        inOrder(node.left, k);
        count++;
        if (count == k) {
            kthValue = node.val;
            return;
        }
        inOrder(node.right, k);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read level order input line
        String[] input = sc.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(input);

        // Read k
        int k = Integer.parseInt(sc.nextLine().trim());

        inOrder(root, k);
        System.out.println(kthValue);
    }
}
