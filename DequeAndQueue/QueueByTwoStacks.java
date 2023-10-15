package DequeAndQueue;

import java.util.*;

public class QueueByTwoStacks {
    private Deque<Integer> in;
    private Deque<Integer> out;

    public QueueByTwoStacks() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    public Integer poll() {
        if (!out.isEmpty()) {
            return out.pollFirst();
        } else if (!in.isEmpty()) {
            move(in, out);
            return out.pollFirst();
        }
        return null;
    }

    public void offer(int element) {
        in.offerFirst(element);
    }

    public Integer peek() {
        if (!out.isEmpty()) {
            return out.peekFirst();
        } else if (!in.isEmpty()) {
            move(in, out);
            return out.peekFirst();
        }
        return null;
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void move(Deque<Integer> in, Deque<Integer> out) {
        while (!in.isEmpty()) {
            out.offerFirst(in.pollFirst());
        }
    }
}