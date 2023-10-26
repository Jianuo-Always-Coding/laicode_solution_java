package Dynamic Programming I & II;

public class Solution {
  public int largestSum(int[] array) {
    int largest = array[0];
    int sum = array[0];
    int[] result = new int[array.length];
    result[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      if (sum > 0) {
        sum = sum + array[i];
      } else {
        sum = array[i];
      }
      largest = Math.max(largest, sum);
    }
    return largest;
  }
}
// TC : O(n)
// SC : O(1)