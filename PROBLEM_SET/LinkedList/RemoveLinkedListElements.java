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
    public ListNode removeElements(ListNode head, int val) {
      // corner case
      if (head == null) {
        return head;
      }
  
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode cur = head;
      ListNode prev = dummy;
      while (cur != null) {
        if (cur.value == val) {
          prev.next = cur.next;
        } else {
          prev = cur;
        }
        cur = cur.next;
  
      }
  
      return dummy.next;
    }
  }
  
  // TC : O(n)
  // SC : O(1)