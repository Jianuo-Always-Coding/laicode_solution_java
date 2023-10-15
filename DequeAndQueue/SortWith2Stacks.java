package DequeAndQueue;

import java.util.*;

public class SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // corner case
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        sort(s1, s2);
    }

    private void sort(Deque<Integer> s1, Deque<Integer> s2) {
        int needToSort = s1.size();
        int haveAlreadySorted = 0;

        while (haveAlreadySorted < needToSort) {
            int max = Integer.MIN_VALUE;
            int count = 0;
            for (int i = 0; i < needToSort - haveAlreadySorted; i++) {
                int val = s1.pollFirst();
                if (val > max) {
                    max = val;
                    count = 1;
                } else if (val == max) {
                    count++;
                }
                s2.offerFirst(val);
            }
            for (int i = 1; i <= count; i++) {
                s1.offerFirst(max);
            }
            haveAlreadySorted += count;

            while (!s2.isEmpty()) {
                int val = s2.pollFirst();
                if (val != max) {
                    s1.offerFirst(val);
                }
            }
        }
    }
}

// TC : O(n^2)
// SC : O(n)