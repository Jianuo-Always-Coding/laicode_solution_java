package HashTable_and_String_I;

public class Solution {
    public int strstr(String large, String small) {
        // corner case
        if (small == null || small.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (isSubString(large, small, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSubString(String large, String small, int index) {
        int smallIndex = 0;
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(i + index) != small.charAt(smallIndex)) {
                return false;
            } else {
                smallIndex++;
            }

        }
        return true;
    }
}

// TC : O((m-n)n)
// SC : O(1)
