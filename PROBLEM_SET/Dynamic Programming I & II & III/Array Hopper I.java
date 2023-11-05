package Dynamic Programming I;

public class Solution {
  public boolean canJump(int[] array) {
    boolean[] result = new boolean[array.length];
    result[0] = true;
    for (int i = 0; i < array.length; i++) {
      if (result[i]) {
        for (int j = 1; j <= array[i]; j++) {
          if (i + j >= array.length) {
            return true;
          } else {
            result[i + j] = true;
          }
          
        }
      }
    }
    return result[result.length - 1];
  }
}

// TC : O(n^2)
// SC : O(n)
