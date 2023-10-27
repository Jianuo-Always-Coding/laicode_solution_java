public class Solution {
  public String compress(String input) {
    // Write your solution here
    // carner case
    if(input == null || input.length() == 0) {
      return input;
    }
    
    
    char[] result = new char[input.length() * 2];
    int slow = 0;
    int fast = 0;
    int cur = 0;
    
    while (fast < input.length()) {
      while (fast < input.length() && input.charAt(fast) == input.charAt(slow)) {
        fast++;
      }
      result[cur++] = input.charAt(slow);
      int start = cur;
      int num = fast - slow;
      while (num != 0) {
        result[cur++] = (char)(num % 10 + '0');
        num = num / 10;
      }
      reverse(result, start, cur-1);
      slow = fast;
    }
    return new String(result,0,cur);
  }

  private void reverse(char[] array, int a, int b) {
    while (a < b) {
      swap(array, a, b);
      a++;
      b--;
    }
  }

  private void swap(char[] array, int a, int b) {
    char temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

}

// TC : O(n)
// SC : O(n)