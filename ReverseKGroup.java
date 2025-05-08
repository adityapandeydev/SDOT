//REVERSE K ELEMENTS
package Questions;
import java.util.*;

public class ReverseKGroup {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to reverse k nodes
    static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node curr = dummy, prev = dummy, next = dummy;
        int count = 0;

        // Count total nodes
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // Reversing in groups of k
        while (count >= k) {
            curr = prev.next;
            next = curr.next;

            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            // Move prev to the end of the reversed group
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }

    // Helper to build the linked list from input
    static Node buildList(String[] input) {
        Node head = null, tail = null;
        for (String val : input) {
            Node newNode = new Node(Integer.parseInt(val));
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }

    // Helper to print the linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read first line (linked list values)
        String[] values = sc.nextLine().split("\\s+");
        Node head = buildList(values);

        // Read second line (value of k)
        int k = sc.nextInt();

        // Perform group reversal
        Node resultHead = reverseKGroup(head, k);

        // Output the modified list
        printList(resultHead);
    }
}
