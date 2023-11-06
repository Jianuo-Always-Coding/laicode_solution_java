public class Solution {
    public boolean exist(int[] array, int target) {
        // corner case
        if (array == null || array.length <= 3) {
            return false;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            for (int j = i + 1; j < array.length - 2; j++) {
                int restVal = target - array[i] - array[j];
                int left = j + 1;
                int right = array.length - 1;
                while (left < right) {
                    int sum = array[left] + array[right];
                    if (sum == restVal) {
                        return true;
                    } else if (sum < restVal) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return false;
    }
}

// TC : O(n^3)
// SC : O(1)
