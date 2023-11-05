public class Solution {
    public List<List<Integer>> allPairs(int[] array, int target) {
      List<List<Integer>> result = new ArrayList<>();
      // corner case
      if (array == null || array.length <= 1) {
        return result;
      }
  
      Map<Integer, Integer> map = new HashMap<>();
  
      for (int i = 0; i < array.length; i++) {
        int pairVal = target - array[i];
        if (map.containsKey(pairVal)) {
          if (map.get(pairVal) == 0) {
            result.add(Arrays.asList(array[i], pairVal));
          }
          map.put(array[i], 1);
          map.put(pairVal, 1);
        } else {
          map.put(array[i], 0);
        }
      }
      return result;
    }
  }
  
  
  // TC : O(n)
  // SC : O(n)