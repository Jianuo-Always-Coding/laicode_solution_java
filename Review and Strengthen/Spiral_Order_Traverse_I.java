package Review and Strengthen;

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    // corner case
    if (matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    helper(matrix, result, 0, matrix.length - 1);
    return result;
  }

  private void helper(int[][] matrix, List<Integer> result, int left, int right) {
    // base case
    if (left == right) {
      result.add(matrix[left][left]);
      return ;
    }
    if (left > right) {
      return ;
    }
    if (left < right) {
      for (int i = left; i < right; i++) {
        result.add(matrix[left][i]);
      }
      for (int i = left; i < right; i++) {
        result.add(matrix[i][right]);
      }
      for (int i = right; i > left; i--) {
        result.add(matrix[right][i]);
      }
      for (int i = right; i > left; i--) {
        result.add(matrix[i][left]);
      }
    }
    helper(matrix, result, left + 1, right - 1);
    
  }

}

// TC : O(n^2)
// SC : O(n)