package String II;

public class Solution {
  public int longest(String input) {
    // corner case
    if (input == null || input.length() == 0) {
      return 0;
    }
    // if (input.length() == 1) {
    //   return 1;
    // }
    Set<Character> set = new HashSet<>();
    int start = 0;
    int longest = 0;
    for (int i = 0; i < input.length(); i++) {
      char cur = input.charAt(i);
      if (!set.add(cur)) {
        while (input.charAt(start) != cur) {
          set.remove(input.charAt(start++));
        }
        start++;
      } 
      longest = Math.max(longest, set.size());
    }
    return longest;
  }
}
