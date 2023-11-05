package Heap&TopK;

public class Solution {
    public int[] kSmallest(int[] array, int k) {
        // corner case
        if (array == null || array.length == 0 || k <= 0) {
            return new int[] {};
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.offer(array[i]);
        }
        for (int i = k; i < array.length; i++) {
            if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        int[] result = new int[maxHeap.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
// TC : O (k + nlogk)
// SC : O(K)