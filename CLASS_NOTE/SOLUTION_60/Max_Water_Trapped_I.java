public class Solution {
    public int maxTrapped(int[] array) {
        // Write your solution here
        // corner case
        if (array == null || array.length <= 2) {
            return 0;
        }
        int sum = 0;
        int leftMax = Math.max(array[0], array[1]);
        int rightMax = Math.max(array[array.length - 1], array[array.length - 2]);
        int left = 1;
        int right = array.length - 2;
        while (left <= right) {
            if (leftMax <= rightMax) {
                sum += leftMax - array[left++];
                leftMax = Math.max(leftMax, array[left]);
            } else {
                sum += rightMax - array[right--];
                rightMax = Math.max(rightMax, array[right]);
            }
        }
        return sum;
    }
}

// TC : O(n)
// SC : O(1)