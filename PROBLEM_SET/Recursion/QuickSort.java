package Recursion;

public class QuickSort {
    public int[] quickSort(int[] array) {
        // Write your solution here
        // corner case
        if (array == null || array.length <= 1) {
            return array;
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        // corner case
        if (left >= right) {
            return;
        }

        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivotVal = array[pivotIndex];
        swap(array, right, pivotIndex);
        int l = left;
        int r = right - 1;

        while (l <= r) {
            if (array[l] < pivotVal) {
                l++;
            } else {
                swap(array, r--, l);
            }
        }
        swap(array, l, right);
        quickSort(array, left, l - 1);
        quickSort(array, l + 1, right);
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
// TC : Worst case : O(n^2) average: O(nlogn)
// SC : WOrst case : O(n) Average : O(logn)