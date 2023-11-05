package Review and Strengthen;

/**
 * Given a string with possible duplicate characters, 
 * return a list with all permutations of the characters.
 */
public class Solution {
  public List<String> permutations(String input) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    char[] array = input.toCharArray();
    helper(result, array, 0);
    return result;
  }

  private void helper(List<String> result, char[] array, int index) {
    // corner case
    if (index == array.length) {
      result.add(new String(array));
      return ;
    }
    Set<Character> set = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      if (set.add(array[i])) {
        swap(array, index, i);
        helper(result, array, index + 1);
        swap(array, index, i);
      } 
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