import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * An example implementation of capacity limited min heap containing only int values,
 * with the capability to do update and poll at a specific index.
 * This is for demonstration of percolateUp/percolate Down methods and
 * how to utilize these methods to do basic heap operations.
 *
 * The public methods provided are:
 * size
 * isEmpty)
 * isFull.
 * peek()
 * poll()
 * offer
 *
 * update(int index, int value) - update the element at index to a given new value
 */

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        this.array = array;
        this.size = size;
    }

    public MinHeap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can not be <= 0");
        }
        array = new int[capacity];
        size = 0;
    }

    private void heapify() {
        for(int i = this.size / 2 - 1; i >= 0; --i) {
            this.percolateDown(i);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
    public void offer(int val) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int)(array.length * 1.5));
        }
        array[size++] = val;
        percolateUp(size - 1);
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is Empty");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is Empty");
        }

        int result = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            if (array[(index - 1) / 2] > array[index]) {
                swap((index - 1) / 2, index);
                index = (index - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int index) {

        while (index <= (size - 2) / 2) {
            // 如果有右孩子
            if (index * 2 + 2 <= size - 1) {
                int bigestIndex = array[index * 2 + 1] >= array[index * 2 + 2] ? index * 2 + 1: index * 2 + 2;
                if (array[bigestIndex] < array[index]) {
                    swap(index, bigestIndex);
                    index = bigestIndex;
                } else {
                    break;
                }
            } else {
                // 只有左孩子
                if (array[index * 2 + 1] < array[index]) {
                    swap(index * 2 + 1, index);
                    index = index * 2 + 1;
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
