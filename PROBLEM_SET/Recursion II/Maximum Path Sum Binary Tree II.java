package Recursion II;

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
    int[] longest = new int[] {Integer.MIN_VALUE};
    helper(root, longest);
    return longest[0];
  }

  private int helper(TreeNode root, int[] longest) {
    // corner case
    if (root == null) {
      return 0;
    }
    int leftVal = Math.max(helper(root.left, longest), 0);
    int rightVal = Math.max(helper(root.right, longest), 0);
    longest[0] = Math.max(longest[0], root.key + leftVal + rightVal);
    return Math.max(leftVal, rightVal) + root.key;
  }
}
// TC : O(n)
// SC : O(heght)