// FLATTEN BINARY TREE TO LINKED LIST
package Questions;
import java.util.*;

public class FlattenBinaryTree {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Pointer to the previous node during reverse preorder
    static TreeNode prev = null;

    static void flatten(TreeNode root) {
        if (root == null) return;

        // Reverse preorder: right then left
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    // Build tree from level-order string input
    public static TreeNode buildTree(String input) {
        if (input == null || input.length() == 0 || input.charAt(0) == 'N') return null;

        String[] parts = input.split("");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < parts.length) {
            TreeNode curr = queue.poll();

            if (i < parts.length && !parts[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.add(curr.left);
            }
            i++;

            if (i < parts.length && !parts[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // Print flattened list (right child as next)
    public static void printRightList(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val);  // print first value without space
        root = root.right;

        while (root != null) {
            System.out.print(" " + root.val);  // prepend space afterward
            root = root.right;
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        TreeNode root = buildTree(input);
        flatten(root);
        printRightList(root);
    }
}
