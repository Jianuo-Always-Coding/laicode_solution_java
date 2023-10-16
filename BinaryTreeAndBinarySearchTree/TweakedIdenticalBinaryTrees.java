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
public class TweakedIdenticalBinaryTrees {
  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
    // corner case
    if (one == null && two == null) {
      return true;
    } else if (one == null || two == null) {
      return false;
    } else if (one.key == two.key) {
      return (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) || (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left));
    }
    return false;
  }
}
// TC : O(4^height)
// SC : O(height)