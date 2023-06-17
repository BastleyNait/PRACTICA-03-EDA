import myExeptions.ExceptionIsEmpty;

public class testQueue {
    public static void main(String[] args) {
        PriorityQueueHeap<String> queue = new PriorityQueueHeap<>();

        queue.enqueue("A", 2);
        queue.enqueue("B", 1);
        queue.enqueue("C", 3);
        System.out.println("Cola de prioridad : " + queue);

        try {
            // mayor prioridad (front)
            System.out.println("Front: " + queue.front());

            // menor prioridad (back)
            System.out.println("Back: " + queue.back());

            // Eliminar un elemento
            System.out.println("Elemento eliminado: " + queue.dequeue());

            // Imprimir la cola de prioridad actualizada
            System.out.println("Cola de prioridad después de eliminar: " + queue);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error ");
        }
    }
}
