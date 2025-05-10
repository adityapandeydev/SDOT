// Rotate List
package Questions;
import java.util.*;

public class RotateLinkedList {

    // Node class for linked list
    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
        }
    }

    // Function to rotate list by k positions
    static Node rotateRight(Node head, int k) {
        if (head == null || k == 0) return head;

        // First, compute the length of the list
        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        // Connect last node to head to make it circular
        tail.next = head;

        // Find the node to break the circle
        int stepsToNewHead = length - k;
        Node newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null; // Break the link

        return newHead;
    }

    // Helper to print the list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" ");
            current = current.next;
        }
        System.out.println();
    }

    // Helper to build a list from input
    static Node buildList(Scanner sc) {
        Node head = null, tail = null;

        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            if (val == -1) break;

            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read linked list
        Node head = buildList(sc);

        // Read value of k
        int k = sc.nextInt();

        // Rotate
        Node newHead = rotateRight(head, k);

        // Print rotated list
        printList(newHead);
    }
}
