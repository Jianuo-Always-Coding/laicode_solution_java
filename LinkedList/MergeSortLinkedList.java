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
    public ListNode mergeSort(ListNode head) {
      // corner case
      if (head == null || head.next == null) {
        return head;
      }
      ListNode mid = findMid(head);
      ListNode temp = mid.next;
      mid.next = null;
      ListNode one = mergeSort(head);
      ListNode two = mergeSort(temp);
      return merge(one, two);
    }
  
    private ListNode merge(ListNode one, ListNode two) {
      ListNode dummy = new ListNode(-1);
      ListNode cur = dummy;
      while (one != null && two != null) {
        if (one.value <= two.value) {
          cur.next = one;
          one = one.next;
          cur = cur.next;
        } else {
          cur.next = two;
          cur = cur.next;
          two = two.next;
        }
      }
      if (one != null) {
        cur.next = one;
      }
      if (two != null) {
        cur.next = two;
      }
      return dummy.next;
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
  }
  
  // TC : o(nlogn)
  // SC : O(logn)
  