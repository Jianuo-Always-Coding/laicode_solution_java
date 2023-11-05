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
    public boolean isPalindrome(ListNode head) {
      // corner case
      if (head == null || head.next == null) {
        return true;
      }
  
      ListNode midNode = findMid(head);
      ListNode temp = midNode.next;
      midNode.next = null;
      ListNode two = reverse(temp);
      ListNode one = head;
  
      while (one != null && two != null) {
        if (one.value != two.value) {
          return false;
        }
        one = one.next;
        two = two.next;
      }
      return true;
    }
  
    private ListNode findMid(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
  
      while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
  
    private ListNode reverse(ListNode head) {
      // corner case
      if (head == null || head.next == null) {
        return head;
      }
  
      ListNode prev = null;
      while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
      }
      return prev;
    }
  }
  
  // TC : O(n)
  // SC : O(1)