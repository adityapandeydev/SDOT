// Implement Stack Using Queues
package Questions;

import java.util.*;

class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push x to stack
    public void push(int x) {
        // Step 1: Push to q2
        q2.add(x);

        // Step 2: Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop from stack
    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.remove();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingQueues stack = new StackUsingQueues();

        int q = sc.nextInt();  // Number of queries

        while (q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                stack.push(x);
            } else if (type == 2) {
                System.out.print(stack.pop() + " ");
            }
        }

        sc.close();
    }
}
