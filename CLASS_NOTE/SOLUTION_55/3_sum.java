public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<>();
    // corner case
    if (array == null || array.length <= 2) {
      return result;
    }

    Arrays.sort(array);
    for (int i = 0; i < array.length - 2; i++) {
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }

      int left = i + 1;
      int right = array.length - 1;
      int restVal = target - array[i];
      while (left < right) {
        int sum = array[left] + array[right];
        if (sum == restVal) {
          result.add(Arrays.asList(array[i], array[left++], array[right--]));
          while (left < right && array[left] == array[left-1]) {
            left++;
          }
          while (left < right && array[right] == array[right+1]) {
            right--;
          }
        } else if (sum > restVal) {
          right--;
        } else {
          left++;
        }
      }
      
    }
    return result;
  }
}

// TC : O(n^2 + nlogn) = O(n^2)
// SC : O(1)
