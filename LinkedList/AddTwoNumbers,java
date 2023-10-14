/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // corner case
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    int count = 0;
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;

    while (l1 != null || l2 != null || count != 0) {
      if (l1 != null) {
        count = count + l1.value;
        l1 = l1.next;
      }
      if (l2 != null) {
        count = count + l2.value;
        l2 = l2.next;
      }
      
      ListNode newNode = new ListNode(count % 10);
      cur.next = newNode;
      cur = cur.next;
      count = count / 10;
    }
    return dummy.next;
  }
}

// TC : O(max(m, n))
//SC : O(1)