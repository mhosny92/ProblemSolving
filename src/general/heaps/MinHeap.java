package general.heaps;

public class MinHeap<T extends Comparable> extends Heap<T> {

    public MinHeap(Class<T> c) {
        super(c);
    }

    public MinHeap(int size, T[] arr) {
        super(size, arr);
    }

    protected void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int smallerIndex = getLeftChildIndex(index);
            if (hasRightChild(index))
                smallerIndex = (leftChild(index).compareTo(rightChild(index)) < 0) ? smallerIndex : getRightChildIndex(index);
            if (arr[smallerIndex].compareTo(arr[index]) < 0) {
                swap(index, smallerIndex);
            } else {
                break;
            }
            index = smallerIndex;
        }
    }

    protected void heapifyUp(int index) {
        while (hasParent(index) && (arr[index].compareTo(parent(index)) < 0)) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
}
