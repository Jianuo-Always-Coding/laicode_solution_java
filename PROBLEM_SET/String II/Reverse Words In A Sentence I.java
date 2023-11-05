package String II;

public class Solution {
  public String reverseWords(String input) {
    // corner case
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    reverse(array, 0, array.length - 1);
    int start = 0;
    int end = 0;
    while ( end < array.length) {
      if (array[end] == ' ') {
        reverse(array, start, end - 1);
        end++;
        start = end;
      } else {
        end++;
      }
    }
    reverse(array, start, end - 1);
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