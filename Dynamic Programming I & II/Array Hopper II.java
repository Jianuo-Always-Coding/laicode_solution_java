package Dynamic Programming I;

public class Solution {
  public int minJump(int[] array) {
    // corner case 
    if (array == null || array.length <= 1) {
      return 0;
    }
    int[] result = new int[array.length];

    for (int i = 1; i < array.length; i++) {
      result[i] = -1;
    }

    for (int i = 0; i < array.length; i++) {
      if (result[i] == -1) {
        continue;
      }
      if (array[i] + i >= array.length) {
        if (result[array.length - 1] == -1) {
          result[array.length - 1] = result[i] + 1; 
        } else {
          result[array.length - 1] = Math.min(result[array.length - 1], result[i] + 1);
        }
      } else {
        for (int j = 1; j <= array[i]; j++) {
          if (result[i + j] == -1) {
            result[i + j] = result[i] + 1;
          } else {
            result[i + j] = Math.min(result[i + j], result[i] + 1);
          }
        }
      }
    }
    return result[result.length - 1];    
  }
}

// TC : O(n^2)
// SC : O(n)
