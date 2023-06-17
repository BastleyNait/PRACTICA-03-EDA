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

    public void elevar(T item) {
        heapArr.add(item);
        elevar(heapArr.size() - 1);
    }

    private void elevar(int childI) {
        int parentI = (childI - 1) / 2;
        T childItem = heapArr.get(childI);

        while (childI > 0 && childItem.compareTo(heapArr.get(parentI)) > 0) {
            heapArr.set(childI, heapArr.get(parentI));
            childI = parentI;
            parentI = (childI - 1) / 2;
        }
        heapArr.set(childI, childItem);
    }

    private void undir(int parentI) {
        int lChildI = 2 * parentI + 1;
        int rChildI = 2 * parentI + 2;
        int largestI = parentI;

        if (lChildI < heapArr.size() && heapArr.get(lChildI).compareTo(heapArr.get(largestI)) > 0) {
            largestI = lChildI;
        }

        if (rChildI < heapArr.size() && heapArr.get(rChildI).compareTo(heapArr.get(largestI)) > 0) {
            largestI = rChildI;
        }

        if (largestI != parentI) {
            swap(parentI, largestI);
            undir(largestI);
        }
    }

    public T removeMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
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
