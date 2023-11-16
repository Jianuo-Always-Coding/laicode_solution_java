public class Solution {
    public int kth(int[] a, int[] b, int k) {
        // corner case
        int aleft = 0;
        int bleft = 0;
        while (k > 1) {
            if (aleft >= a.length) {
                return b[bleft + k - 1];
            }
            if (bleft >= b.length) {
                return a[aleft + k - 1];
            }

            int amid = aleft + k / 2 - 1;
            int bmid = bleft + k / 2 - 1;
            int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
            int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
            if (aval < bval) {
                aleft = amid + 1;
            } else {
                bleft = bmid + 1;
            }
            k = k - k / 2;
        }
        if (aleft >= a.length) {
            return b[bleft];
        }
        if (bleft >= b.length) {
            return a[aleft];
        }
        return Math.min(a[aleft], b[bleft]);
    }
}

// TC : O(logn)
// SC : O(1)
