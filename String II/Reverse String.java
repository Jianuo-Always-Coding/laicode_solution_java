package String II;

public class Solution {
  public String reverse(String input) {
    // corner case
    if (input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    for (int i = 0; i < input.length() / 2; i++) {
      swap(array, i , input.length() - 1 - i);
    }
    return new String(array);
  }

  private void swap(char[] array, int a, int b) {
    char temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}

// TC ; O(n)
// SC : O(1)