package Heap&TopK;

public class Solution {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> e1, List<Integer> e2) {
                long disA = distance(e1, a, b, c);
                long disB = distance(e2, a, b, c);
                if (disA == disB)
                    return 0;
                return disA < disB ? -1 : 1;
            }
        });
        Set<List<Integer>> set = new HashSet<>();
        minHeap.offer(Arrays.asList(0, 0, 0));
        set.add(Arrays.asList(0, 0, 0));
        for (int i = 1; i < k; i++) {
            List<Integer> cur = minHeap.poll();
            if (cur.get(0) < a.length - 1 && set.add(Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2)))) {
                minHeap.offer(Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2)));
            }
            if (cur.get(1) < b.length - 1 && set.add(Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2)))) {
                minHeap.offer(Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2)));
            }
            if (cur.get(2) < c.length - 1 && set.add(Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1))) {
                minHeap.offer(Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1));
            }
        }
        List<Integer> node = minHeap.poll();
        return Arrays.asList(a[node.get(0)], b[node.get(1)], c[node.get(2)]);
    }

    private long distance(List<Integer> e, int[] a, int[] b, int[] c) {
        int d1 = a[e.get(0)];
        int d2 = b[e.get(1)];
        int d3 = c[e.get(2)];
        return d1 * d1 + d2 * d2 + d3 * d3;
    }
}

// TC : O(logk)
// SC : O(k)
