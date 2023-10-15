public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here
        // corner case
        if (array == null || array.length <= 1) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;
        int cur = left;
        while (cur <= right) {
            if (array[cur] == -1) {
                swap(array, left++, cur++);
            } else if (array[cur] == 0) {
                cur++;
            } else {
                swap(array, cur, right--);
            }
        }
        return array;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

// TC : O(n)
// SC : O(1)