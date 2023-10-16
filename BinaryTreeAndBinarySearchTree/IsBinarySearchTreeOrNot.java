package BinaryTreeAndBinarySearchTree;

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
  public boolean isBST(TreeNode root) {
    // corner case
    if (root == null) {
      return true;
    }
    return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean helper(TreeNode root, int left, int right) {
    if (root == null) {
      return true;
    }

    if (root.key > left && root.key < right) {
      return helper(root.left, left, root.key) && helper(root.right, root.key, right);
    }
    return false;
  }
}

// TC : O(n)
// SC : O(height)