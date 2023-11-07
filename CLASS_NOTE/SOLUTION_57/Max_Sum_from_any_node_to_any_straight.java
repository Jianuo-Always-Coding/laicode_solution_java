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
    int[] result = new int[] {Integer.MIN_VALUE};
    helper(root, result);
    return result[0];
  }

  private int helper(TreeNode root, int[] result) {
    // base case
    if (root == null) {
      return 0;
    }
    int leftVal = Math.max(helper(root.left, result), 0);
    int rightVal = Math.max(helper(root.right, result), 0);

    result[0] = Math.max(result[0], Math.max(leftVal, rightVal) + root.key);
    return Math.max(leftVal, rightVal) + root.key;
  }
}

// TC : O(n)
// SC : O(height)
