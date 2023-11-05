package Review and Strengthen;

/*
 * Given an array of elements, reorder it as follow:

 * { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

 * { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

 * Try to do it in place.
 * 
 */

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