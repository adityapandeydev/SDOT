//Reorder List
package Questions;
import java.util.*;

public class ReorderLinkedList {

    // Node class definition
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to reorder the list
    static void reorderList(Node head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        Node second = reverseList(slow.next);
        slow.next = null; // Split the list

        // Step 3: Merge first half and reversed second half alternately
        Node first = head;
        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    // Reverse a linked list
    static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Build linked list from space-separated input
    static Node buildList(String[] input) {
        Node head = null, tail = null;
        for (String val : input) {
            Node newNode = new Node(Integer.parseInt(val));
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }

    // Function to print the list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" ");
            current = current.next;
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().trim().split("\\s+");

        Node head = buildList(input);
        reorderList(head);
        printList(head);
    }
}
