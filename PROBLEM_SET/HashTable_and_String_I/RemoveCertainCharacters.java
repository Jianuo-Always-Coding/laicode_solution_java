package HashTable_and_String_I;

public class Solution {
    public String remove(String input, String t) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }

        char[] array = input.toCharArray();
        int cur = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!set.contains(array[i])) {
                array[cur] = array[i];
                cur++;
            }
        }
        return new String(array, 0, cur);
    }
}

// TC : O(m + n)
// SC : O(n) n is the length of removeable string