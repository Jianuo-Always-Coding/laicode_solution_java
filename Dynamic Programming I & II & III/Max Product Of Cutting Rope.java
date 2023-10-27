package Dynamic Programming I;

public class Solution {
  public int maxProduct(int length) {
    // Write your solution here
    int[] array = new int[length + 1];
    array[2] = 1;
    for (int i = 3; i <= length; i++) {
      for (int j = 1; j < i; j++) {
        array[i] = Math.max(Math.max(array[j], j) * (i - j), array[i]);
      }
    }
    return array[length];
  }
}

// TC : O(n^2)
// SC : O(n)