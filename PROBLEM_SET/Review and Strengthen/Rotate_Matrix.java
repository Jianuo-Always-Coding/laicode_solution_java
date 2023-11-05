package Review and Strengthen;

public class Solution {
  public void rotate(int[][] matrix) {
    // Write your solution here
    // corner case
    if (matrix == null || matrix.length <= 1) {
      return ;
    }
    
    int left = 0;
    int right = matrix.length - 1;
    while (left < right) {
      for (int i = left; i < right; i++) {
        int temp = matrix[left][i];
        matrix[left][i] = matrix[right - i + left][left];
        matrix[right - i + left][left] = matrix[right][right - i + left];
        matrix[right][right - i + left] = matrix[i][right];
        matrix[i][right] = temp;
      }
      left++;
      right--;
    }
    return ;
  }
}

//TC : O(n^2)
//SC : O(1)
