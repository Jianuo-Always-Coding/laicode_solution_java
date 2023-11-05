public class Solution {
    public List<String> permutations(String input) {
      List<String> result = new ArrayList<>();
      // corner case
      if (input == null) {
        return result;
      }
      if (input.length() == 0) {
        result.add("");
        return result;
      }
      char[] array = input.toCharArray();
      helper(array, result, 0);
      return result;
    }
  
    private void helper(char[] array, List<String> result, int index) {
      // base case
      if (index == array.length - 1) {
        result.add(new String(array));
        return ;
      }
  
      for (int i = index; i < array.length; i++) {
        swap(array, index, i);
        helper(array, result, index + 1);
        swap(array, index, i);
      }
    }
  
    private void swap(char[] array, int a, int b) {
      char temp = array[a];
      array[a] = array[b];
      array[b] = temp;
    }
  } 
  // TC : O(n!)
  // SC : O(n)