public class Solution {
    public int smallestElementLargerThanTarget(int[] array, int target) {
        // corner case
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (array[left] > target) {
            return left;
        }
        if (array[right] > target) {
            return right;
        }
        return -1;
    }
}

// TC : O(logn)
// SC : O(1)
