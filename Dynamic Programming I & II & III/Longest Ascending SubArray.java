package Dynamic Programming I & II & III;

public class Solution {
  public int longest(int[] array) {
    // corner case
    if (array.length <= 1) {
      return array.length;
    }

    int longest = 1;
    int number = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) {
        number++;
      } else {
        number = 1;
      }
      longest = Math.max(longest, number);
    }
    return longest; 
  }
}


// TC : O(n)
// SC : O(1)