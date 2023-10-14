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
    public ListNode merge(ListNode one, ListNode two) {
      // corner case
      if (one == null) {
        return two;
      }
  
      if (two == null) {
        return one;
      }
  
      ListNode onePointer = one;
      ListNode twoPointer = two;
      ListNode dummy = new ListNode(-1);
      ListNode cur = dummy;
  
      while (onePointer != null && twoPointer != null) {
        if (onePointer.value <= twoPointer.value) {
          cur.next = onePointer;
          onePointer = onePointer.next;
          cur = cur.next;
        } else {
          cur.next = twoPointer;
          twoPointer = twoPointer.next;
          cur = cur.next;
        }
      }
  
      if (onePointer != null) {
        cur.next = onePointer;
      }
      if (twoPointer != null) {
        cur.next = twoPointer;
      }
  
      return dummy.next;
    }
  }
  
  // TC : O(m + n)
  // SC : O(1)
  