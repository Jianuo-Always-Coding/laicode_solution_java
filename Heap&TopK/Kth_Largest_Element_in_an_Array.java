package Heap&TopK;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Write your solution here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        int index = 0;
        while (index < k) {
            minHeap.offer(nums[index++]);
        }

        while (index < nums.length) {
            int temp = minHeap.peek();
            if (nums[index] > temp) {
                minHeap.poll();
                minHeap.offer(nums[index]);
            }
            index++;
        }       
        return minHeap.poll();
    }
}
// TC : O(k + (n - k)logk)
// SC : O(k)
