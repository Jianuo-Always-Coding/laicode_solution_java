package String II;

public class Solution {
  public boolean match(String input, String pattern) {
    // corner case
    int p1 = 0;
    int p2 = 0;
    int count = 0;
    while (p1 < input.length() && p2 < pattern.length()) {
      if (pattern.charAt(p2) >= '0' && pattern.charAt(p2) <= '9') {
        while (p2 < pattern.length() && pattern.charAt(p2) >= '0' && pattern.charAt(p2) <= '9') {
          count = count * 10 + (int)(pattern.charAt(p2) - '0');
          p2++;
        }
        p1 = p1 + count;
        count = 0;
        continue;
      } else {
        if (input.charAt(p1) == pattern.charAt(p2)) {
          p1++;
          p2++;
        } else {
          return false;
        }
      }
    }
    if (p1 == input.length() && p2 == pattern.length() ) {
      return true;
    }
    return false;
  }
}

// TC : O(n)
// SC : O(1)