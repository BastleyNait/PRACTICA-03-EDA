package heapArr;

public class test {
    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(2);
        heap.insert(5);
        heap.insert(6);
        heap.insert(8);
        heap.insert(3);
        heap.insert(10);
        heap.insert(1);
        heap.insert(7);
        System.out.println(heap);
    }
}
