import myExeptions.ExceptionIsEmpty;

public class testHeap {
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

        // heap
        System.out.println(heap);

        try {
            // elemento máximo
            int maxElement = heap.getMax();
            System.out.println("Máximo elemento: " + maxElement);

            // elemento mínimo
            int minElement = heap.getMin();
            System.out.println("Mínimo elemento: " + minElement);

            // Eliminar el elemento máximo
            int removedElement = heap.removeMax();
            System.out.println("Elemento eliminado: " + removedElement);

            // Imprimir el heap actualizado
            System.out.println("Heap después de eliminar: " + heap);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
