
public class testQueue {
    public static void main(String[] args) {
        PriorityQueueHeap<String> queue = new PriorityQueueHeap();

        queue.enqueue("A", 2);
        queue.enqueue("B", 1);
        queue.enqueue("C", 3);

        System.out.println(queue);
    }
}
