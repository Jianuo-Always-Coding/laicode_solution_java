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
    public boolean hasCycle(ListNode head) {
      // corner case
      if (head == null) {
        return false;
      }
  
      ListNode slow = head;
      ListNode fast = head;
  
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {
          return true;
        }
      }
      return false;
    }
  }
  
  // TC : O(n)
  // SC : O(1)