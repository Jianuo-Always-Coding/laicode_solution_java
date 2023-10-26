package Dynamic Programming I & II;

public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here
    boolean[] array = new boolean[input.length() + 1];
    array[0] = true;
    Set<String> set = new HashSet<>();

    for (String e : dict) {
      set.add(e);
    }
    // i is how many characters contains
    for (int i = 1; i <= input.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (array[j] && contains(input, j, i - 1, set)) {
          array[i] = true;
          break;
        }
      }
    }
    return array[array.length - 1];
  }

  private boolean contains(String input, int left, int right, Set<String> set) {
    // corner case
    String temp = input.substring(left, right + 1);
    if (set.contains(temp)) {
      return true;
    }
    return false;
  }
}

// TC : O(n^2)
// SC : O(n)