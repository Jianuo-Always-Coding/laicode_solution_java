public class Solution {
    public List<List<Integer>> allPairs(int[] array, int target) {
      List<List<Integer>> result = new ArrayList<>();
      // corner case
      if (array == null || array.length <= 1) {
        return result;
      }
  
      // Integer is the number value in array, List<Integer> is the index list of such values.
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < array.length; i++) {
        int pairVal = target - array[i];
        if (map.containsKey(pairVal)) {
          addToResult(i, map.get(pairVal), result);
        }
        
        if (!map.containsKey(array[i])) {
          map.put(array[i], new ArrayList<Integer>());
        } 
        map.get(array[i]).add(i);
      }
      return result;
    }
  
    private void addToResult(int index, List<Integer> list, List<List<Integer>> result) {
      for (Integer num : list) {
        result.add(Arrays.asList(num, index));
      }
    }
  }
  
  
  // TC : O(n)
  // SC : O(n)