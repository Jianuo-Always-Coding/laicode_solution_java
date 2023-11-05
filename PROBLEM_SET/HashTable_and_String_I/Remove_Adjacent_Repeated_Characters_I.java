package HashTable_and_String_I;

public class Solution {
    public String deDup(String input) {
        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }
        int cur = 1;
        char[] array = input.toCharArray();
        for (int i = 1; i < input.length(); i++) {
            if (array[i] != array[cur - 1]) {
                array[cur++] = array[i];
            }
        }
        return new String(array, 0, cur);
    }
}

// TC : O(n)
// SC : O(1)