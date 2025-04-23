// ODD EVEN LINKED LIST
package Questions;

import java.util.*;

public class OddEvenLinkedList {

    // Definition for singly-linked list node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read space-separated input
        String[] values = sc.nextLine().trim().split("\\s+");

        // Build initial linked list
        Node head = null, tail = null;
        for (String val : values) {
            int num = Integer.parseInt(val);
            Node newNode = new Node(num);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Separate into even and odd linked lists
        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;
        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            } else {
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            }
            current = current.next;
        }

        // Combine even and odd lists
        if (evenTail != null) {
            evenTail.next = oddHead;
        }

        if (oddTail != null) {
            oddTail.next = null;
        }

        // Set new head (evenHead if exists, else oddHead)
        head = (evenHead != null) ? evenHead : oddHead;

        // Print final list
        current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" ");
            current = current.next;
        }
        System.out.println();
    }
}
