package String II;

public class Solution {
  public String rightShift(String input, int n) {
    // corner case
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int len = n % array.length;
    if (len == 0) {
      return input;
    }
    reverse(array, 0, array.length - 1);
    reverse(array, 0, len - 1);
    reverse(array, len, array.length - 1);
    return new String(array);
  }

  private void reverse(char[] array, int a, int b) {
    for (int i = 0; i <= (b - a) / 2; i++) {
      swap(array, a + i, b - i);
    }
  }

  private void swap(char[] array, int a, int b) {
    char temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}

// TC : O(n)
// SC : O(1)
