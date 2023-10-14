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
    public ListNode middleNode(ListNode head) {
      // corner case
      if (head == null) {
        return head;
      }
  
      ListNode slow = head;
      ListNode fast = head;
      while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
  }
  
  // TC : O(n)
  // SC : O(1)