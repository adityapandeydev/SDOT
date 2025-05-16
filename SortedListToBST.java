// CONVERT SORTED LIST TO BST
package Questions;
import java.util.*;

public class SortedListToBST {

    // List Node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Tree Node class
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static ListNode head;

    // Function to build BST from sorted list
    public static TreeNode sortedListToBST(int n) {
        if (n <= 0) return null;

        // Recursively build left subtree
        TreeNode left = sortedListToBST(n / 2);

        // Create root with current head node
        TreeNode root = new TreeNode(head.val);
        root.left = left;

        // Move head pointer forward
        head = head.next;

        // Recursively build right subtree
        root.right = sortedListToBST(n - n / 2 - 1);

        return root;
    }

    // Preorder traversal
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input list
        String[] input = sc.nextLine().trim().split("\\s+");

        // Build linked list
        head = new ListNode(Integer.parseInt(input[0]));
        ListNode curr = head;

        for (int i = 1; i < input.length; i++) {
            curr.next = new ListNode(Integer.parseInt(input[i]));
            curr = curr.next;
        }

        // Get number of nodes
        int n = input.length;

        // Convert to balanced BST
        TreeNode root = sortedListToBST(n);

        // Print preorder traversal
        preorder(root);
    }
}
