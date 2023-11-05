/*
 *  interface Dictionary {
 *    public Integer get(int index);
 *  }
 */

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.

public class SearchedInUnknowSizedSortedArray {
    public int search(Dictionary dict, int target) {
        // first search area, then search in the area
        int left = 0;
        int right = 1;

        while (dict.get(right) != null) {
            if (dict.get(right) < target) {
                left = right + 1;
                right = right * 2;
            } else {
                break;
            }
        }

        while (left <= right) {
            int mid = left + (right - left);
            if (dict.get(mid) == null) {
                right = mid - 1;
            } else if (dict.get(mid) == target) {
                return mid;
            } else if (dict.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}