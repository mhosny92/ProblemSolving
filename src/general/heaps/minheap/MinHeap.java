package general.heaps.minheap;

import java.util.Arrays;

public class MinHeap<T extends Comparable> {
    private final int initialcapcaity = 10;
    private int heapSize;
    private int capacity;
    private T[] heapArr;

    public MinHeap(int heapSize, T[] heapArr) {
        if (heapSize == 0)
            throw new IllegalStateException();
        this.heapSize = heapSize;
        this.heapArr = heapArr;
        this.capacity = initialcapcaity;
        heapify(0);
    }

    private void heapify(int index) {
        int smallest = index;
        if (hasLeftChild(index) && (heapArr[getLeftChildIndex(index)].compareTo(heapArr[index]) < 0)) {
            smallest = getLeftChildIndex(index);
        }
        if (hasRightChild(index) && (heapArr[getRightChildIndex(index)].compareTo(heapArr[smallest]) < 0)) {
            smallest = getRightChildIndex(index);
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    public T peek() {
        if (heapSize == 0) throw new IllegalStateException();
        return heapArr[0];
    }

    public T poll() {
        if (heapSize == 0) throw new IllegalStateException();
        T obj = heapArr[0];
        heapArr[0] = heapArr[heapSize - 1];
        heapSize--;
        heapifyDown();
        return obj;
    }


    public void add(T obj) {
        ensureExtraCapacity();
        heapArr[heapSize] = obj;
        heapSize++;
        heapifyUp();
    }

    public int size() {
        return heapSize;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerIndex = getLeftChildIndex(index);
            if (hasRightChild(index))
                smallerIndex = (leftChild(index).compareTo(rightChild(index)) < 0) ? smallerIndex : getRightChildIndex(index);
            if (heapArr[smallerIndex].compareTo(heapArr[index]) < 0) {
                swap(index, smallerIndex);
            } else {
                break;
            }
            index = smallerIndex;
        }
    }

    private void heapifyUp() {
        int index = heapSize - 1;
        while (hasParent(index) && (parent(index).compareTo(heapArr[index]) < 0)) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private T leftChild(int parentIndex) {
        return heapArr[parentIndex * 2 + 1];
    }

    private T rightChild(int parentIndex) {
        return heapArr[parentIndex * 2 + 2];
    }

    private T parent(int childIndex) {
        return heapArr[(childIndex - 1) / 2];
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return (index * 2) + 1 < heapSize;
    }

    private boolean hasRightChild(int index) {
        return (index * 2) + 2 < heapSize;
    }

    private boolean hasParent(int index) {
        return (index - 1) / 2 > 0;
    }

    private void swap(int indexOne, int indexTwo) {
        T temp = heapArr[indexOne];
        heapArr[indexOne] = heapArr[indexTwo];
        heapArr[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (heapSize == capacity) {
            heapArr = Arrays.copyOf(heapArr, capacity * 2);
        }
        capacity *= 2;
    }

}
