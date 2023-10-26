package Recursion II;

public class Solution {
  public int[] reorder(int[] array) {
    // Write your solution here
    // corner case
    if (array == null || array.length <= 3) {
      return array;
    }

    int slow = 0;
    int fast = array.length / 2;
    int[] result = new int[array.length];
    

    int index = 0;
    while (index < array.length - 1) {
      result[index++] = array[slow++];
      result[index++] = array[fast++];
    }
    if (fast < array.length) {
      result[index] = array[fast];
    }
    return result;
  }

}

// TC : O(n)
// SC : O(1)