import java.util.PriorityQueue;

public class priorityQueue {
    public static void main(String[] args) {
        // Priority Queue Min Type
        PriorityQueue<Integer> p = new PriorityQueue<>();

        // Add elements to the queue
        p.add(3);
        p.add(10);
        p.add(7);
        p.add(2);

        // Print the head of the queue
        System.out.println("Head of Queue : " + p.peek());

    }
}

// PriorityQueue is a special type of queue where elements are processed based
// on priority, not FIFO.
// By default, it follows natural ordering (smallest element has the highest
// priority).
// You can define a custom priority using a Comparator.