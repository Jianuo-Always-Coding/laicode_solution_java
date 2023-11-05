package HashTable_and_String_I;

public class Solution {
  public String deDup(String input) {
    // corner case
    if (input == null || input.length() <= 1) {
      return input;
    }
    
    char[] array = input.toCharArray();
    int slow = 1; // all the elements on the left of  slow is what we need
    int fast = 1; // is currently the element that we are considering
    while (fast < input.length()) {
      if (slow == 0) {
        array[slow++] = array[fast++];
      } else if (array[slow - 1] == array[fast]) {
        while (fast < input.length() && array[slow - 1] == array[fast]) {
          fast++;
        }
        slow--;
      } else {
        array[slow++] = array[fast++];
      } 
    }
    return new String(array, 0, slow);
  }
}

// TC : O(n)
// SC : O(1)
