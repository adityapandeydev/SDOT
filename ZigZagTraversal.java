//BINARY TREE ZIG ZAG LEVEL ORDER TRAVERSAL
package Questions;

import java.util.*;

public class ZigZagTraversal {

    // Binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from level-order input with 'N' representing nulls
    public static TreeNode buildTree(String[] input) {
        if (input.length == 0 || input[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!input[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(input[i]));
                queue.add(current.left);
            }
            i++;

            if (i >= input.length) break;

            // Right child
            if (!input[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(input[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Zigzag traversal method
    public static List<Integer> zigZagTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] level = new Integer[size];

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                int index = leftToRight ? i : size - 1 - i;
                level[index] = curr.val;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            for (int val : level) {
                result.add(val);
            }

            leftToRight = !leftToRight; // Change direction
        }

        return result;
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().trim().split("\\s+");

        TreeNode root = buildTree(input);
        List<Integer> result = zigZagTraversal(root);

        // Format output as space-separated values
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

