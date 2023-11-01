package Dynamic Programming I & II & III;

public class Solution {
  public int editDistance(String one, String two) {
    // Asumpt that one and two are null
    int[][] steps = new int[one.length() + 1][two.length() + 1];
    for (int i = 0; i <= two.length(); i++) {
      steps[0][i] = i;
    }

    for (int i = 1; i <= one.length(); i++) {
      steps[i][0] = i;
    }

    for (int i = 1; i <= one.length(); i++) {
      for (int j = 1; j <= two.length(); j++) {
        if (one.charAt(i - 1) == two.charAt(j - 1)) {
          steps[i][j] = Math.min(steps[i - 1][j - 1], Math.min(steps[i - 1][j] + 1, steps[i][j - 1] + 1));
        } else {
          steps[i][j] = Math.min(steps[i - 1][j - 1], Math.min(steps[i - 1][j], steps[i][j - 1])) + 1;
        }
      }
    }
    return steps[one.length()][two.length()];
  }
}

// TC : O(mn)
// SC : O(mn)
