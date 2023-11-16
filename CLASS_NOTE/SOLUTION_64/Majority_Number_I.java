public class Solution {
  public int majority(int[] array) {
    int value = array[0];
    int count = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] == value){
        count++;
      } else {
        if (count > 0) {
          count--;
        } else if (count == 0) {
          value = array[i];
          count = 1;
        }
      }
    }
    return value;
  }
}

// TC : O(n)
// SC : O(1)
