public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here
    // corner case
    if (input == null || input.length() == 0) {
      return input;
    }
    boolean seenSpace = true;
    char[] array = input.toCharArray();
    int cur = 0;

    for (int i = 0; i < input.length(); i++) {
      if (array[i] != ' ') {
        array[cur++] = array[i];
        seenSpace = false;
      } else if (!seenSpace) {
        array[cur++] = array[i];
        seenSpace = true;
      }
    }
    if (cur > 0 && array[cur - 1] == ' ') {
      cur--;
    }

    return new String(array, 0, cur);
  }
}
// TC : O(n)
// SC : O(1)