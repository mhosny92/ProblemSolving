package general.heaps;

public class MaxHeap<T extends Comparable> extends Heap<T> {

    public MaxHeap(Class<T> c) {
        super(c);
    }

    public MaxHeap(int size, T[] arr) {
        super(size, arr);
    }

    protected void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int largerIndex = getLeftChildIndex(index);
            if (hasRightChild(index))
                largerIndex = (leftChild(index).compareTo(rightChild(index)) > 0) ? largerIndex : getRightChildIndex(index);
            if (arr[largerIndex].compareTo(arr[index]) > 0) {
                swap(index, largerIndex);
            } else {
                break;
            }
            index = largerIndex;
        }
    }

    protected void heapifyUp(int index) {
        while (hasParent(index) && (arr[index].compareTo(parent(index)) > 0)) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }


}
