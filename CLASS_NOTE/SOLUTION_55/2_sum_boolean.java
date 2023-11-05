public class Solution {
    public boolean existSum(int[] array, int target) {
      // corner case
      if (array == null || array.length == 0) {
        return false;
      }
  
      Set<Integer> set = new HashSet<>();
  
      for (int i = 0; i < array.length; i++) {
        int pairVal = target - array[i];
        if (set.contains(pairVal)) {
          return true;
        }
        set.add(array[i]);
      }
      return false;
    }
  }
  
  // TC : O(n)
  // SC : O(n)
  