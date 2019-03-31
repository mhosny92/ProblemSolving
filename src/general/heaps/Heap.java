package general.heaps;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class Heap<T extends Comparable> {
    protected int size;
    protected int capacity;
    protected T[] arr;

    protected Heap(Class<T> c) {
        capacity = 10;
        arr = (T[]) Array.newInstance(c, capacity);
    }

    public Heap(int size, T[] arr) {
        this.size = size;
        this.capacity = size;
        this.arr = arr;
        for (int i = 0; i < size; i++) {
            heapifyUp(i);
        }
    }

    protected abstract void heapifyDown(int index);

    protected abstract void heapifyUp(int index);

    public T peek() {
        if (size == 0) throw new IllegalStateException();
        return arr[0];
    }

    public T poll() {
        if (size == 0) throw new IllegalStateException();
        T obj = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown(0);
        return obj;
    }

    public void add(T obj) {
        ensureExtraCapacity();
        arr[size] = obj;
        size++;
        heapifyUp(size - 1);
    }

    public int size() {
        return size;
    }


    protected T leftChild(int parentIndex) {
        return arr[parentIndex * 2 + 1];
    }

    protected T rightChild(int parentIndex) {
        return arr[parentIndex * 2 + 2];
    }

    protected T parent(int childIndex) {
        return arr[(childIndex - 1) / 2];
    }

    protected int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    protected int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    protected int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    protected boolean hasLeftChild(int index) {
        return (index * 2) + 1 < size;
    }

    protected boolean hasRightChild(int index) {
        return (index * 2) + 2 < size;
    }

    protected boolean hasParent(int index) {
        return (index - 1) / 2 >= 0;
    }

    protected void swap(int indexOne, int indexTwo) {
        T temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }

    protected void ensureExtraCapacity() {
        if (size == capacity) {
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity *= 2;
        }
    }
}
