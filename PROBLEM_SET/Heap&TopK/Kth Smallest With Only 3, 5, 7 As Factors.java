package Heap&TopK;

public class Solution {
    public long kth(int k) {
        // Write your solution here
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(2 * k);

        minHeap.offer(3 * 5 * 7);
        set.add(3 * 5 * 7);
        for (int i = 1; i < k; i++) {
            int val = minHeap.poll();
            if (set.add(val * 3)) {
                minHeap.offer(val * 3);
            }
            if (set.add(val * 5)) {
                minHeap.offer(val * 5);
            }
            if (set.add(val * 7)) {
                minHeap.offer(val * 7);
            }
        }
        return (long) (minHeap.poll());
    }
}

// TC : O(klogk)
// SC : O(k)
