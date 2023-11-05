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
  public TreeNode reverse(TreeNode root) {
    // corner case
    if (root == null) {
      return null;
    }

    TreeNode prev = null;
    TreeNode prevRight = null;
    while (root != null) {
      TreeNode left = root.left;
      TreeNode right = root.right;
      root.left = prev;
      root.right = prevRight;
      prev = root;
      prevRight = right;
      root = left;
    }
    return prev;
  }
}

// TC : O(height)
// SC : O(1)
