package DequeAndQueue;

import java.util.*;

/*
 * Implement a stack containing integers using queue(s). The stack should provide push(x), pop(), top() and isEmpty() operations.
 * In java: if the stack is empty, then top() and pop() will return null.
 */

class StackByQueue {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public StackByQueue() {
        queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        move();
        return queue.poll();
    }

    /** Get the top element. */
    public Integer top() {
        if (isEmpty()) {
            return null;
        }
        move();
        Integer val = queue.peek();
        queue.offer(queue.poll());
        return val;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    private void move() {
        int size = queue.size();
        for (int i = 1; i < size; i++) {
            queue.offer(queue.poll());
        }
    }
}
