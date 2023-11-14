/**
 * class ListNode {
 * public int value;
 * public ListNode next;
 * public ListNode(int value) {
 * this.value = value;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode merge(List<ListNode> listOfLists) {
        // Write your solution here/.

        ListNode dummy = new ListNode(-1);
        ListNode resultCur = dummy;
        int k = listOfLists.size();
        if (k <= 0) {
            return dummy.next;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.value == n2.value) {
                    return 0;
                }
                return n1.value < n2.value ? -1 : 1;
            }
        });

        for (int i = 0; i < k; i++) {
            ListNode cur = listOfLists.get(i);
            if (cur != null) {
                minHeap.offer(cur);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode cur = minHeap.poll();
            resultCur.next = cur;
            resultCur = resultCur.next;
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }
        }
        return dummy.next;
    }

}