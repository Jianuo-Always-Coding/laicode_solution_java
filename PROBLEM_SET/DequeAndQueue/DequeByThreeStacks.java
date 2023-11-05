package DequeAndQueue;

import java.util.*;

/*
 * Implement a deque by using three stacks. The queue should provide size(), isEmpty(), offerFirst(), offerLast(), pollFirst(), pollLast(), peekFirst() and peekLast() operations. When the queue is empty, pollFirst(), pollLast(), peekFirst() and peek() should return null.
 */

public class DequeByThreeStacks {
    private Deque<Integer> in;
    private Deque<Integer> out;
    private Deque<Integer> buffer;

    public DequeByThreeStacks() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst(int element) {
        out.offerFirst(element);
    }

    public void offerLast(int element) {
        in.offerFirst(element);
    }

    public Integer pollFirst() {
        if (out.isEmpty()) {
            move(in, out);
        }
        return out.pollFirst();
    }

    public Integer pollLast() {
        if (in.isEmpty()) {
            move(out, in);
        }
        return in.pollFirst();
    }

    public Integer peekFirst() {
        if (out.isEmpty()) {
            move(in, out);
        }
        return out.peekFirst();
    }

    public Integer peekLast() {
        if (in.isEmpty()) {
            move(out, in);
        }
        return in.peekFirst();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void move(Deque<Integer> s1, Deque<Integer> s2) {
        int size = s1.size() / 2;
        for (int i = 0; i < size; i++) {
            buffer.offerFirst(s1.pollFirst());
        }
        while (!s1.isEmpty()) {
            s2.offerFirst(s1.pollFirst());
        }
        while (!buffer.isEmpty()) {
            s1.offerFirst(buffer.pollFirst());
        }
    }
}
