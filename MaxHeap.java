package heapArr;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {
    private ArrayList<T> heapArr;

    public MaxHeap() {
        heapArr = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heapArr.isEmpty();
    }

    private void swap(int index1, int index2) {
        T temp = heapArr.get(index1);
        heapArr.set(index1, heapArr.get(index2));
        heapArr.set(index2, temp);
    }

    public void insert(T item) {
        heapArr.add(item);
        insert(heapArr.size() - 1);
    }

    private void insert(int childI) {
        int parentI = (childI - 1) / 2;
        T childItem = heapArr.get(childI);

        while (childI > 0 && childItem.compareTo(heapArr.get(parentI)) > 0) {
            heapArr.set(childI, heapArr.get(parentI));
            childI = parentI;
            parentI = (childI - 1) / 2;
        }
        heapArr.set(childI, childItem);
    }

    @Override
    public String toString() {
        return this.heapArr.toString();
    }
}
