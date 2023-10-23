package HashTable_and_String_I;

public class Solution {
    public int missing(int[] array) {
        // Write your solution here
        int N = array.length + 1;
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = result ^ i;
        }
        for (int i = 0; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }
}

// TC : O(n)
// SC : O(1)