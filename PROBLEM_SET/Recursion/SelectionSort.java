public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here
    // corner case
    if (array == null || array.length <= 1) {
      return array;
    }
    for (int i = 0; i < array.length - 1; i++) {
      int globalMinIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[globalMinIndex] > array[j]) {
          globalMinIndex = j;
        }
      }
      swap(array, globalMinIndex, i);
    }
    return array;
  }

  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}

// TC : O(n ^ 2)
// SC : O(1)
