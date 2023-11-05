package DequeAndQueue;
/*  
Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.

push(int element) - push the element to top
pop() - return the top element and remove it, if the stack is empty, return -1
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMin {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public StackWithMin() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public int pop() {
        if (!stack.isEmpty()) {
            int val = stack.pollFirst();
            if (minStack.peekFirst() == val) {
                minStack.pollFirst();
            }
            return val;
        }
        return -1;
    }

    public void push(int element) {
        stack.offerFirst(element);
        if (minStack.isEmpty() || element <= minStack.peekFirst()) {
            minStack.offerFirst(element);
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peekFirst();
    }

    public int min() {
        return minStack.isEmpty() ? -1 : minStack.peekFirst();
    }
}
