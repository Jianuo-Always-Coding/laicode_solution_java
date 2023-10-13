// Assumptions

// 1. A is not null
// 2. K is guranteed to be >= 0 and K is guranteed to be <= A.length


public class Solution {
    public int[] kClosest(int[] array, int target, int k) {
        // corner case
        if (array == null || array.length == 0 || k <= 0) {
            return new int[] {};
        }

        int [] result = new int[k];
        int closestIndex = findClosest(array, target);
        int left = closestIndex;
        int right = closestIndex + 1;
        int index = 0;
        while (left >= 0 && right < array.length && index < k) {
            if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                result[index++] = array[left--];
            } else {
                result[index++] = array[right++];
            }
        }
        if (left >= 0 && index < k) {
            while (index < k) {
                result[index++] = array[left--];
            }
        }
        if (right < array.length && index < k) {
            while (index < k) {
                result[index++] = array[right++];
            }
        }
        return result;
    }

    private int findClosest(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            return left;
        }
        return right;
    }
}

// TC : O(logn + k)
// SC : O(1)
