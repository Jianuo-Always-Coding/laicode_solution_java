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
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    // base case
    if (root == null) {
      return null;
    }
    if (root.equals(one) || root.equals(two)) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);

    if (left == null && right == null) {
      return null;
    } else if (left == null || right == null) {
      return left == null ? right : left;
    }
    return root;
  }
}

// TC : O(n)
// SC : O(height)