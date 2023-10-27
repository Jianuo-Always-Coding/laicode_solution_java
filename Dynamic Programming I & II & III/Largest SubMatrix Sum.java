public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here
    // corner case
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return 0;
    }

    // 拍扁，变成n行一维array的prifix sum
    int[][] colSum = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix[0].length; i++) {
      colSum[0][i] = matrix[0][i];
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        colSum[i][j] = colSum[i - 1][j] + matrix[i][j];
      }
    }

    int largest = Integer.MIN_VALUE;
    int sum = 0;

    // i is the index of the first line ,j is the index of the last line
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix.length; j++) {
        int[] sumPrifix = new int[matrix[0].length];
        for (int k = 0; k < matrix[0].length; k++) {
          sumPrifix[k] = colSum[j][k] - colSum[i][k] + matrix[i][k];
        }

        // prifix for sumPrifix
        sum = 0;
        for (int k = 0; k < matrix[0].length; k++) {
          if (sum > 0) {
            sum = sum + sumPrifix[k];
          } else {
            sum = sumPrifix[k];
          }
          largest = Math.max(largest, sum);
        }
      }
    }
    return largest;
  }
}

// the size of the matrix is M * N
// TC : O(mn + m^2 * n)
// SC : O(mn)