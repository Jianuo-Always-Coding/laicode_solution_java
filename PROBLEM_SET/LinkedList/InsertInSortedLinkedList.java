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
    public ListNode insert(ListNode head, int value) {
      // corner case
      if (head == null) {
        return new ListNode(value);
      }
  
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode newNode = new ListNode(value);
  
      ListNode prev = dummy;
      ListNode cur = head;
  
      while (cur != null) {
        if (cur.value > value) {
          break;
        } else {
          prev = cur;
          cur = cur.next;
        }
      }
      prev.next = newNode;
      newNode.next = cur;
      return dummy.next;
    }
  }
  
  // TC : O(n)
  // SC : O(1)
  