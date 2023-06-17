public class PriorityQueueHeap<T extends Comparable<T>> {
    private MaxHeap<PriorityItem<T>> heap;

    public PriorityQueueHeap() {
        heap = new MaxHeap<>();
    }

    // enqueue.

    public void enqueue(T item, int priority) {
        PriorityItem<T> priorityItem = new PriorityItem<>(item, priority);
        heap.insert(priorityItem);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private class PriorityItem<T extends Comparable<T>> implements Comparable<PriorityItem<T>> {
        private T item;
        private int priority;

        public PriorityItem(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }

        public T getItem() {
            return item;
        }

        public int compareTo(PriorityItem<T> other) {
            return Integer.compare(priority, other.priority);
        }
    }

}