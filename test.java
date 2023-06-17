package heapArr;

public class test {
    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.elevar(2);
        heap.elevar(5);
        heap.elevar(6);
        heap.elevar(8);
        heap.elevar(3);
        heap.elevar(10);
        heap.elevar(1);
        heap.elevar(7);
        System.out.println(heap);
    }
}
