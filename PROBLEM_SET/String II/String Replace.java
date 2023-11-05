public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    StringBuilder sb = new StringBuilder();
    int index = 0;
    while (index <= input.length() - source.length()) {
      if (contains(input, source, index)) {
        sb.append(target);
        index = index + source.length();
        continue;
      } else {
        sb.append(input.charAt(index++));
      }
    }

    while (index < input.length()) {
      sb.append(input.charAt(index++));
    }
    return sb.toString();
  }

  private boolean contains(String input, String sub, int index) {
    for (int i = 0; i < sub.length(); i++) {
      if (input.charAt(index + i) != sub.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}

// TC : O(mn)
// SC : O(length of result)
