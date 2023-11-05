# LinkedList
## Notice
> - Can not loose the control of head
> - Can not do dereference to null
> - **mergeSortLinkedList** and **CheckIfLinkedListIsPalindrome** can be used to review this section.

## Reverse a Linked List Recursive
**corner case && base case**

    if (head == null || head.next == null) {
        return head;
    }

## Check If Linked List Has A Cycle
**In while loop**

In the while loop, we should first move two pointers, then compare. This can help us go through the first case, slow = fast = head.

    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {
          return true;
        }
      }

## Remove Linked List Elements
**In while loop**

    while (cur != null) {
      // If need to delete, then delete. Do not move prev
      if (cur.value == val) {
        prev.next = cur.next;
      } else {
        // If don't need to delete, just move to next.
        prev = cur;
      }
      // Whatever need to move cur
      cur = cur.next;
    }
