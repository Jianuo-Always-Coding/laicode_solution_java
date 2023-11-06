package CLASS_NOTE.SOLUTION_57;

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public int maxPathSum(TreeNode root) {
    int[] globalMax = new int[] {Integer.MIN_VALUE};
    // corner case
    if (root == null) {
      return globalMax[0];
    }
    
    helper(root, globalMax);
    return globalMax[0];
  }

  private int helper(TreeNode root, int[] globalMax) {
    // base case
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return root.key;
    } else if (root.left == null) {
      return root.key + helper(root.right, globalMax);
    } else if (root.right == null) {
      return root.key + helper(root.left, globalMax);
    }
    int leftVal = helper(root.left, globalMax);
    int rightVal = helper(root.right, globalMax);
    globalMax[0] = Math.max(globalMax[0], leftVal + rightVal + root.key);
    return Math.max(leftVal, rightVal) + root.key;
  } 
}

// TC : O(n)
// SC : O(height)