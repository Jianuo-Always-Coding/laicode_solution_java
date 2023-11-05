/**
 * class RandomListNode {
 * public int value;
 * public RandomListNode next;
 * public RandomListNode random;
 * public RandomListNode(int value) {
 * this.value = value;
 * }
 * }
 */

public class Solution {
    public RandomListNode copy(RandomListNode head) {
        // corner case
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.value);
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        // MUST PUT HEAD AND NEWHEAD INTO MAP
        map.put(head, newHead);
        RandomListNode cur = newHead;

        while (head != null) {
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new RandomListNode(head.next.value));
                }
                cur.next = map.get(head.next);
            }

            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                cur.random = map.get(head.random);
            }

            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }
}
// TC : O(n)
// SC : O(n)