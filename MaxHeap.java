import myExeptions.ExceptionIsEmpty;
import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {
    // ArrayList para almacenar los elementos del heap
    private ArrayList<T> heapArr;

    public MaxHeap() {
        heapArr = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heapArr.isEmpty();
    }

    // Inserta un elemento en el heap y lo eleva a su posición adecuada
    public void insert(T item) {
        heapArr.add(item);
        elevar(heapArr.size() - 1);
    }

    // Eleva un elemento en el índice dado hasta su posición adecuada en el heap
    private void elevar(int childIndex) {
        int parentIndex = (childIndex - 1) / 2;
        T childItem = heapArr.get(childIndex);

        while (childIndex > 0 && childItem.compareTo(heapArr.get(parentIndex)) > 0) {
            heapArr.set(childIndex, heapArr.get(parentIndex));
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }

        heapArr.set(childIndex, childItem);
    }

    public T getMax() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El heap está vacío");
        }
        return heapArr.get(0);
    }

    public T getMin() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El heap está vacío");
        }
        T minItem = heapArr.get(0);
        for (int i = 1; i < heapArr.size(); i++) {
            T currentItem = heapArr.get(i);
            if (currentItem.compareTo(minItem) < 0) {
                minItem = currentItem;
            }
        }
        return minItem;
    }

    // Hunde un elemento en el índice dado hasta su posición adecuada en el heap
    private void undir(int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        int largestIndex = parentIndex;

        if (leftChildIndex < heapArr.size() && heapArr.get(leftChildIndex).compareTo(heapArr.get(largestIndex)) > 0) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < heapArr.size() && heapArr.get(rightChildIndex).compareTo(heapArr.get(largestIndex)) > 0) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != parentIndex) {
            swap(parentIndex, largestIndex);
            undir(largestIndex);
        }
    }

    // Intercambia dos elementos en los índices dados
    private void swap(int index1, int index2) {
        T temp = heapArr.get(index1);
        heapArr.set(index1, heapArr.get(index2));
        heapArr.set(index2, temp);
    }

    // Elimina y devuelve el elemento de mayor valor (raíz del heap)
    public T removeMax() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Heap esta vacio");
        }

        T maxItem = heapArr.get(0);
        T lastItem = heapArr.remove(heapArr.size() - 1);

        if (!isEmpty()) {
            heapArr.set(0, lastItem);
            undir(0);
        }

        return maxItem;
    }

    @Override
    public String toString() {
        return this.heapArr.toString();
    }
}
