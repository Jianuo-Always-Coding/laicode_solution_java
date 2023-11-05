package Heap&TopK;

public class Solution {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        Map<String, Integer> map = new HashMap<>();
        for (String s : combo) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                        int value1 = e1.getValue();
                        int value2 = e2.getValue();
                        if (value1 == value2) {
                            return 0;
                        }
                        return value1 < value2 ? -1 : 1;
                    }
                });

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(e);
            } else if (e.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(e);
            }
        }
        String[] result = new String[minHeap.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;

    }
}

// TC : O(n + nlogk)
// SC : O(n)