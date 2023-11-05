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
    public ListNode partition(ListNode head, int target) {
      // corner case
      if (head == null || head.next == null) {
        return head;
      }
  
      ListNode small = new ListNode(-1);
      ListNode largerOrEqual = new ListNode(-1);
      ListNode s = small;
      ListNode l = largerOrEqual;
  
      while (head != null) {
        if (head.value < target) {
          s.next = head;
          s = s.next;
        } else {
          l.next = head;
          l = l.next;
        }
        head = head.next;
      }
      l.next = null;
      s.next = largerOrEqual.next;
      return small.next;
    }
  }
  
  // TC : O(n)
  // SC : O(1)
  