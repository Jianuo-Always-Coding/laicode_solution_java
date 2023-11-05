package Recursion;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        // corner case
        if (array == null || array.length <= 1) {
            return array;
        }
    
        int[] helper = new int[array.length];
        mergeSort(array, 0, array.length - 1, helper);
        return array;
    }
    
    private void mergeSort(int[] array, int left, int right, int[] helper) {
        // base case
        if (left >= right) {
            return ;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid, helper);
        mergeSort(array, mid + 1, right, helper);
        merge(array, left, mid, right, helper);
    }
    
    private void merge(int[] array, int left, int mid, int right, int[] helper) {
        // corner case
        if (left == right) {
            return ;
        }
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int r = mid + 1;
        int index = left;
        while (left <= mid && r <= right) {
            if (helper[left] <= helper[r]) {
                array[index++] = helper[left++];
            } else {
                array[index++] = helper[r++];
            }
        }
    
        while (left <= mid) {
            array[index++] = helper[left++];
        }
    
        while (r <= right) {
            array[index++] = helper[r++];
        }
    }
    
    // TC : O(nlogn)
    // SC : O(n)
}
