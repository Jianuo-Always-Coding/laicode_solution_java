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
public class SymmetricBinaryTree {
  public boolean isSymmetric(TreeNode root) {
    // corner case
    if (root == null) {
      return true;
    }
    return helper(root.left, root.right);
  }

  private boolean helper(TreeNode left, TreeNode right) {
    // base case
    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    } else if (left.key == right.key) {
      return helper(left.left, right.right) && helper(left.right, right.left);
    }
    return false;
  }
}
// TC :O(n)
// SC :O(height)

