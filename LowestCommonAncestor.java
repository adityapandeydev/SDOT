// LOWEST COMMON ANCESTOR OF BST
package Questions;
import java.util.*;

public class LowestCommonAncestor {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to build the binary tree from level-order input (with -1 for nulls)
    public static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            // Left child
            if (!arr[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i >= arr.length) break;

            // Right child
            if (!arr[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // Function to find LCA in a binary tree (works for any binary tree, not necessarily BST)
    public static TreeNode findLCA(TreeNode root, int x, int y) {
        if (root == null) return null;
        if (root.val == x || root.val == y) return root;

        TreeNode left = findLCA(root.left, x, y);
        TreeNode right = findLCA(root.right, x, y);

        if (left != null && right != null) return root; // x and y are in different subtrees
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read tree input in level order
        String[] arr = sc.nextLine().trim().split("\\s+");

        // Read x and y
        String[] xy = sc.nextLine().trim().split("\\s+");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        TreeNode root = buildTree(arr);
        TreeNode lca = findLCA(root, x, y);

        if (lca != null) {
            System.out.println(lca.val);
        }
    }
}
