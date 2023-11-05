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
    public ListNode reorder(ListNode head) {
      // corner case
      if (head == null || head.next == null) {
        return head;
      }
  
      ListNode mid = findMid(head);
      ListNode temp = mid.next;
      mid.next = null;
      ListNode two = reverse(temp);
      ListNode one = head;
  
      while (one != null && two != null) {
        ListNode nextOne = one.next;
        ListNode nextTwo = two.next;
        one.next = two;
        two.next = nextOne;
        one = nextOne;
        two = nextTwo;
      }
      return head;
    }

    // find a midNode in the Linked List head, and ensure that [0, mid] is less or equal than [mid+1, list.size() - 1]
    private ListNode findMid(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
  
      while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
  
    private ListNode reverse(ListNode temp) {
      ListNode prev = null;
  
      while (temp != null) {
        ListNode next = temp.next;
        temp.next = prev;
        prev = temp;
        temp = next;
      }
      return prev;
    }
  }
  
  // TC : O(n)
  // SC : O(1)