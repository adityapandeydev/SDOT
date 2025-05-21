//IMPLEMENT QUEUE USING STACKS
package Questions;
import java.util.*;

public class QueueUsingStacks {

    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Enqueue operation (Push)
        public void push(int x) {
            s1.push(x);
        }

        // Dequeue operation (Pop) — FIFO behavior
        public int pop() {
            if (s2.isEmpty()) {
                // Transfer elements from s1 to s2 for FIFO access
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            if (s2.isEmpty()) {
                return -1;  // Queue is empty
            } else {
                return s2.pop();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine());

        Queue queue = new Queue();

        for (int i = 0; i < q; i++) {
            String[] input = sc.nextLine().split(" ");
            int type = Integer.parseInt(input[0]);

            if (type == 1) {
                int x = Integer.parseInt(input[1]);
                queue.push(x);
            } else if (type == 2) {
                System.out.println(queue.pop());
            }
        }
    }
}
